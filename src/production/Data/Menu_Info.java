package production.Data;


public class Menu_Info {
    public double cost;
    public double overall_rating;

    public Menu_Info() {
    }

    public double Get_cost() {
        return this.cost;
    }

    public double Set_cost(double new_val) {
        this.cost = new_val;
        return new_val;
    }

    public double Get_rating() {
        return this.overall_rating;
    }
}

