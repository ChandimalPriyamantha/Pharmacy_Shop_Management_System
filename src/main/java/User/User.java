package User;

public interface User {
    public void addUser(String id,String name,String contactNo,String password,String salary,String email);
    public void editUser(String name,String contactNo,String password,String salary,String email,String cID);
    public void deleteUser(String cID);
}
