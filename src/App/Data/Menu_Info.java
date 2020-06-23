package App.Data;


public class Menu_Info {
    public int cost;
    public double overall_rating;

    public Menu_Info() {
    }

    public int Get_cost() {
        return this.cost;
    }

    public int Set_cost(int new_val) {
        this.cost = new_val;
        return new_val;
    }

    public double Get_rating() {
        return this.overall_rating;
    }
}

