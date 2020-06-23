package App.Data;

public class Client {
    public Client_Info info;
    public String email;
    public int id;
    public String name;
    public boolean sex;
    public String address;

    public Client() {
    }

    public void Request_info() {
    }

    public void Request_all() {
    }

    public final Client_Info Get_info() {
        return this.info;
    }

    public final String Get_email() {
        return this.email;
    }
}

