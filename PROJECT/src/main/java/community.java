import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class community {
    int joined= 0;
    String name;
    String bio;
    String rules;
    ArrayList<User> admins = new ArrayList<>();
    ArrayList<post> post_community = new ArrayList<post>();
    ArrayList<User> member = new ArrayList<User>();
    Scanner scanner = new Scanner(System.in);
    public void show_all_post_in_community(){
        System.out.println("please enter the name of community");

        String name_community = scanner.next();

        for(community community1: Main2.communities){
            if(Objects.equals(community1.name, name_community)){
                community = community1;
            }
        }

        for(post post: community.post_community){
            post.showing_post();
        }
    }
    static community community;
    public void remove(User user){
        System.out.println("please enter the name of community");

        String name_community = scanner.next();
        System.out.println("please enter the name of the user you want to remove");
        String username = scanner.next();

        for(community community1: Main2.communities){
            if(Objects.equals(community1.name, name_community)){
                community = community1;
            }
        }
        for(User user1:admins){
            if(user1 == user){
                for(User user2:member){
                    if(Objects.equals(user2.id, username)){
                        community.member.remove(user2);
                        community.joined--;
                    }
                }
            }
        }
    }

    public void add_admin(User user){
        System.out.println("enter the username that you want to make them an admin in this community");
        String username = scanner.next();
        System.out.println("please enter the name of the community");
        String name_community = scanner.next();
        for(community community1: Main2.communities){
            if(Objects.equals(community1.name, name_community)){
                community = community1;
            }
        }
        for(User user1:admins){
            if(user1 == user){
                for(User user2:member){
                    if(Objects.equals(user2.id, username)){
                        community.admins.add(user2);

                    }
                }
            }
        }
    }


}
