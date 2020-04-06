package kiec.ireneusz.spellsandgloryserver.domain.user;

import kiec.ireneusz.spellsandgloryserver.domain.user.dto.*;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.*;
import kiec.ireneusz.spellsandgloryserver.enums.ItemType;
import kiec.ireneusz.spellsandgloryserver.exception.*;
import kiec.ireneusz.spellsandgloryserver.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserFacade {

    private final UserService userService;
    private final HeroService heroService;
    private final ItemService itemService;
    private final EquipmentService equipmentService;
    private final BackpackService backpackService;
    private final Item2BackpackService item2BackpackService;
    private final Item2EquipmentService item2EquipmentService;

    @Autowired
    public UserFacade(
            UserService userService,
            HeroService heroService,
            ItemService itemService,
            EquipmentService equipmentService,
            BackpackService backpackService,
            Item2BackpackService item2BackpackService,
            Item2EquipmentService item2EquipmentService
    ) {
        this.userService = userService;
        this.heroService = heroService;
        this.itemService = itemService;
        this.equipmentService = equipmentService;
        this.backpackService = backpackService;
        this.item2BackpackService = item2BackpackService;
        this.item2EquipmentService = item2EquipmentService;
    }

    //region USER
    public List<UserDTO> getUsers() {
        return userService.getAll().stream()
                .map(Mapper::toUserDTOSimple).collect(Collectors.toList());
    }

    public UserDTO getUser(Long userId) throws UserNotFoundException {
        return Mapper.toUserDTO(userService.getOne(userId));
    }

    public List<UserDTO> getUsersByMail(String mail) {
        return userService.getByMail(mail).stream()
                .map(Mapper::toUserDTOSimple).collect(Collectors.toList());
    }

    public List<UserDTO> getUsersByUsername(String username) {
        return userService.getByUsername(username).stream()
                .map(Mapper::toUserDTOSimple).collect(Collectors.toList());
    }

    public UserDTO createUser(UserApi api) {
        return Mapper.toUserDTO(userService.create(api));
    }

    public UserDTO updateUser(Long userId, UserUpdateApi api) throws UserNotFoundException {
        return Mapper.toUserDTO(userService.update(userId, api));
    }

    public void deleteUser(Long userId) throws UserNotFoundException {
        User user = userService.getOne(userId);
        heroService.deleteByUser(user);
        userService.delete(userId);
        //TODO split heroService and CampService, delete both rows for player (heroes, camps)
    }

    //endregion

    //region HERO
    public List<HeroDTO> getHeroes() {
        return heroService.getAll().stream().map(Mapper::toHeroDTOSimple)
                .collect(Collectors.toList());
    }

    public HeroDTO getHero(Long heroId) throws HeroNotFoudException {
        return new HeroDTO(heroService.getOne(heroId));
    }

    public List<HeroDTO> getHeroesByName(String name) {
        return heroService.getByName(name).stream().map(Mapper::toHeroDTOSimple)
                .collect(Collectors.toList());
    }

    public List<HeroDTO> getHeroesByUser(Long userId) throws UserNotFoundException {
        User user = userService.getOne(userId);
        return heroService.getByUser(user).stream().map(Mapper::toHeroDTOSimple)
                .collect(Collectors.toList());
    }

    public HeroDTO createHero(HeroApi api) throws UserNotFoundException, ItemNotFoundException {
        User user = userService.getOne(api.getUserId());
        Hero hero = heroService.create(user, api);
        Equipment equipment = equipmentService.create(hero);
        item2EquipmentService.createItemsSlots(equipment);
        Item firstItem = itemService.getFirstItem(hero);
        Backpack backpack = backpackService.create(hero);
        item2BackpackService.addItemToBackpack(backpack, firstItem);
        return new HeroDTO(hero);
    }

    public HeroDTO updateHero(Long heroId, HeroUpdateApi api) throws HeroNotFoudException {
        return new HeroDTO(heroService.update(heroId, api));
    }

    public void deleteHero(Long heroId) throws HeroNotFoudException {
        heroService.delete(heroId);
    }
    //endregion

    //region ITEM
    public List<ItemDTO> getItems() {
        return itemService.getAll().stream().map(Mapper::toItemDTOSimple)
                .collect(Collectors.toList());
    }

    public ItemDTO getItem(Long itemId) throws ItemNotFoundException {
        return new ItemDTO(itemService.getOne(itemId));
    }

    public List<ItemDTO> getItemsByType(ItemType itemType) {
        return itemService.getByType(itemType).stream().map(Mapper::toItemDTOSimple)
                .collect(Collectors.toList());
    }

//    @ManyToMany
//    @JoinTable(
//            name="AuthorBookGroup",
//            joinColumns={@JoinColumn(name="fk_author", referencedColumnName="id")},
//            inverseJoinColumns={@JoinColumn(name="fk_group", referencedColumnName="id")})
//    @MapKey(name = "title")
//    public List<ItemDTO> getItemsByPrice(Long lowestPrice, Long highestPrice) {
//        return itemService.getByPrice(lowestPrice, highestPrice).stream().map(Mapper::toItemDTOSimple)
//                .collect(Collectors.toList());
//    }
//TODO only in shop

    public ItemDTO createItem(ItemApi api) {
        return new ItemDTO(itemService.create(api));
    }

    public ItemDTO updateItem(Long itemId, ItemApi api) throws ItemNotFoundException {
        return new ItemDTO(itemService.update(itemId, api));
    }

    public void deleteItem(Long itemId) throws ItemNotFoundException {
        itemService.delete(itemId);
    }

    //endregion

    //region EQUIPMENT
    public List<EquipmentDTO> getEquipments() {
        return equipmentService.getAll().stream()
                .map(Mapper::toEquipmentDTOSimple)
                .collect(Collectors.toList());
    }

    public EquipmentDTO getEquipment(Long heroId) throws HeroNotFoudException, EquipmentNotFoundException {
        Hero hero = heroService.getOne(heroId);
        Equipment equipment = equipmentService.getByHero(hero);
//        HashMap<ItemType, ItemDTO> itemsDTOs = new HashMap<>();
//        equipment.getItems().entrySet().stream()
//                .forEach(e -> itemsDTOs.put(e.getKey(),new ItemDTO(e.getValue())));
        ArrayList<Item> items = new ArrayList<>(equipment.getItems().values());
        List<ItemDTO> itemDTOs = items.stream().map(Mapper::toItemDTOSimple).collect(Collectors.toList());
        return new EquipmentDTO(equipment,itemDTOs);
    }

    public EquipmentDTO wearItem(Long heroId, Long itemId)
            throws HeroNotFoudException,
                    EquipmentNotFoundException,
                    ItemNotFoundException,
                    Item2EquipmentNotFoundException,
                    BackpackNotFoudExeption {
        Hero hero = heroService.getOne(heroId);
        Equipment equipment = equipmentService.getByHero(hero);
        Backpack backpack = backpackService.getByHero(hero);
        Item item = itemService.getOne(itemId);
        Long oldItemId = item2EquipmentService.wearItem(equipment, item);
        if(oldItemId != null) {
            Item oldItem = itemService.getOne(oldItemId);
            item2BackpackService.addItemToBackpack(backpack, oldItem);
        }
        ArrayList<Item> items = new ArrayList<>(equipment.getItems().values());
        List<ItemDTO> itemDTOs = items.stream().map(Mapper::toItemDTOSimple).collect(Collectors.toList());
        return new EquipmentDTO(equipment,itemDTOs);
    }

    public EquipmentDTO takeOfItem(Long heroId, Long itemId)
            throws HeroNotFoudException,
                    ItemNotFoundException,
                    EquipmentNotFoundException,
                    Item2EquipmentNotFoundException {
        Hero hero = heroService.getOne(heroId);
        Equipment equipment = equipmentService.getByHero(hero);
        Item item = itemService.getOne(itemId);
        item2EquipmentService.takeOfItem(equipment, item);
        ArrayList<Item> items = new ArrayList<>(equipment.getItems().values());
        List<ItemDTO> itemDTOs = items.stream().map(Mapper::toItemDTOSimple).collect(Collectors.toList());
        return new EquipmentDTO(equipment,itemDTOs);
    }

    //endregion

    //region BACKPACK

    //endregion

}
