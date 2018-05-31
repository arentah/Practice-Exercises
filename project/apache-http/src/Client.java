public class Client {
    private String business;
    private String address;
    private String name;
    private String phone_number;
    private String type;
    public Client(String business, String address, String name, String phone_number, String type){
        this.business = business;
        this.address = address;
        this.name = name;
        this.phone_number = phone_number;
        this.type = type;
    }

    public String getBusiness() {
        return business;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getType() {
        return type;
    }
}
