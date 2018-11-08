package model;
class Role {

    //Fields
    private int role_id;
    private String role_description;

    /**
     * @return Get role_id
     */
    public int getRole_id() {
        return role_id;
    }
    /**
     * @param  role_id role_id
     */
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
    /**
     * @return  Get role_description, Tenant or Employee
     */
    public String getRole_Description() {
        return role_description;
    }

    /**
     * @param  role_description role_description, Tenant or Employee
     */
    public void setRole_description(String role_description) {
        this.role_description = role_description;
    }
}