package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;


   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "cars_id")
   private Car carsId;


   public User() {}
   
   public User(String firstName, String lastName, String email, Car carsId) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.carsId = carsId;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
   public Car getCarsId() {
      return carsId;
   }

   public void setCarsId(Car carsId) {
      this.carsId = carsId;
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              ", carsId=" + carsId +
              '}';
   }
}