import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;


public class Main2 {
    static HashMap<String, Integer> important_info = new HashMap<String, Integer>();
    static ArrayList<User> All_users = new ArrayList<User>();
    static ArrayList<community> communities = new ArrayList<>();
    static User user1;
    static Scanner scanner = new Scanner(System.in);

    static void login() {

        System.out.print("please enter your info" + "\nusername: ");

        String username = scanner.next();
        System.out.print("\npassword: ");
        String password = scanner.next();
        int pass_hash = password.hashCode();

        if (pass_hash == important_info.get(username)) {
            System.out.println("\nyou loged in succesfully");
            for (User user : All_users) {

                if (Objects.equals(user.id, username)) {
                    user1 = user;
                    break;
                }
            }
        } else {
            System.out.println("something went wrong");
        }
    }

    static void sign_in() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("hello there welcome to REDDIT please enter your username and password");

        System.out.print("username: ");
        String username = scanner.next();
        System.out.print("\npassword: ");
        String password = scanner.next();
        int hash_pass = password.hashCode();

        User user = new User();
        user.id = username;
        important_info.put(username, hash_pass);
        All_users.add(user);
    }

    public static void search() {
        System.out.println("what are you searching 1.user 2.community?");
        int input = scanner.nextInt();
        ArrayList<String> matchingStrings = new ArrayList<>();

        if (input == 1) {
            String userInput = scanner.next();
            for (User user : All_users) {
                if (user.id.contains(userInput)) {
                    matchingStrings.add(user.id);
                }
            }

        }


        if (input == 2) {
            String userInput = scanner.next();
            for (community community : communities) {
                if (community.name.contains(userInput)) {
                    matchingStrings.add(community.name);
                }
            }
        }

        for (String str : matchingStrings) {
            if (str != null) {
                System.out.println(str);
            } else {
                System.out.println("nothing found");
            }
        }

    }

    public static void time_line(User user) {
        for (community community : user.Communities) {
            user.show_user.add(community.post_community.getLast());
        }
        user.show_user(user);

    }


    static community community = new community();

    public static void main(String[] args) {
        System.out.println("hello welcome to reddit\ndo you hava an account? if you dont then you can become a redditor rightnow!\n1.signin 2.login");
        int chose = scanner.nextInt();
        if (chose == 1) {
            sign_in();
            login();
        } else {
            login();
        }
        while (true) {
            System.out.println("welcome!\nwhat do you want to do?\n1.check your profile\n2.check you timeline\n3.search\n4.making_post\n5.making community\n6.making a post in a community\n7.see your saved post\n8.join a community\n9.removing someone from a community(only if youu are an admin)\n10.making an admin in a community\n11.do you wanna see the posts in a communt\n 12.see the post that you have voted\n13.exit ");
            chose = scanner.nextInt();
            switch (chose) {
                case 1:
                    user1.show_info_user(user1);
                    break;
                case 2:
                    time_line(user1);
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    user1.making_post();
                    break;
                case 5:
                    user1.making_community(user1);
                    break;
                case 6:
                    user1.making_post_in_community();
                    break;
                case 7:
                    user1.show_saved_post();
                    break;
                case 8:
                    user1.join(user1);
                    break;
                case 9:
                    community.remove(user1);
                    break;
                case 10:
                    community.add_admin(user1);
                    break;
                case 11:
                    community.show_all_post_in_community();
                    break;
                case 12:
                    user1.show_voted_post(user1);
                    break;
                case 13:
                    System.exit(0);

            }


        }
    }
}