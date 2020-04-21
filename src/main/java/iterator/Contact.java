package iterator;

//Профиль пользователя соц сети
public class Contact {
    String name;
    String type; //тип контакта: друг, семья, работа

    public Contact(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
