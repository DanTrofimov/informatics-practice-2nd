package REST.services;


import REST.models.User;
import REST.repository.UserRepository;

public class RestService {
    UserRepository userRepository;

    public RestService(){
        userRepository = new UserRepository();
    }
    public void createUser(User user){
        userRepository.create(user);
    }
    public void updateUser(User user){
        userRepository.update(user);
    }
    public User getUser(User user){
        return userRepository.get(user.getId());
    }
    public void deleteUser(User user){
        userRepository.delete(user.getId());
    }
}