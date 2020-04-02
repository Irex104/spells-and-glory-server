package kiec.ireneusz.spellsandgloryserver.domain.user;

import kiec.ireneusz.spellsandgloryserver.domain.camp.Camp;
import kiec.ireneusz.spellsandgloryserver.domain.character.model.Hero;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.UserApi;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.UserUpdateApi;
import kiec.ireneusz.spellsandgloryserver.enums.Gender;
import kiec.ireneusz.spellsandgloryserver.enums.Rang;
import kiec.ireneusz.spellsandgloryserver.enums.Role;
import kiec.ireneusz.spellsandgloryserver.utils.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(schema = "public", name = "users")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotNull
    private String mail;
    @NotNull
    private String username;
    @NotNull
    private String password;
    private String description;
    @NotNull
    private String image;

    @NotNull
    private Long level;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Rang rang;
    @NotNull
    private Long currentExperience;
    @NotNull
    private Long toNextLevelExperience;
    @NotNull
    private Long gold;
    @Column(name = "premium_coins", nullable = false)
    private Long premiumCoins;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            schema = "public", name = "heroes2user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "hero_id")
    )
    private List<Hero> heroes;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            schema = "public", name = "camp2user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "camp_id")
    )
    private List<Camp> camps;

    public User(UserApi api) {
        this.role = Role.USER;
        this.gender = api.getGender();
        this.mail = api.getMail();
        this.username = api.getUsername();
//        this.password = api.getPassword(); //TODO Ten parametr ma być w Login - rozbić usera na 2 encje informacyjną i autoryzacyjną
        this.description = api.getDescription();
        this.image = api.getImage();
        this.level = 1L;
        this.rang = Rang.Arrival;
        this.currentExperience = 0L;
        this.toNextLevelExperience = 10000L;
        this.gold = 1000L;
        this.premiumCoins = 10L;
    }

    public void update(UserUpdateApi api) {
        this.gender = api.getGender();
//        this.mail = api.getMail()
        this.username = api.getUsername();
//        this.password = api.getPassword();
        this.description = api.getDescription();
        this.image = api.getImage();
    }
}

