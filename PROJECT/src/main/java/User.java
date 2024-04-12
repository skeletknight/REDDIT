import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class User {
    String id;
    int karma=0 ;
    ArrayList <post> User_posted = new ArrayList<post>();
    ArrayList <post> show_user = new ArrayList<post>();
    ArrayList<community> Communities = new ArrayList<community>();
    ArrayList<post> saved = new ArrayList<post>();
    ArrayList<post> voted = new ArrayList<>();

    static community community1;
    Scanner scanner = new Scanner(System.in);
    //methods
    public void show_info_user(User user){
        System.out.println(user.id);
        System.out.println(user.karma);
        for(community community:user.Communities){
            System.out.println(community.name);
        }
        int count =0;
        for (post post: User_posted){
            count++;
            System.out.print(count +"titles of the posts:" +post.title_of_post);
            System.out.println("do want to do anything about this posts? 1.saving 2.nothing");
            int input = scanner.nextInt();
            if(input==1){
                System.out.println("which post do you want to save? insert the number");
                input = scanner.nextInt();
                saved.add(User_posted.get(input));
                System.out.println("post saved!");
            }
            else{
                System.exit(0);//it can turn into return
            }
            post.showing_post();
        }


    }
    public void show_user(User user){
        int count = 0;
        for(post post : show_user){
            count++;
            System.out.println(count + ".tile: " + post.title_of_post);
        }
        System.out.println("which post you want to see ? please enter the number");
        int input = scanner.nextInt();
        post post1 = show_user.get(input-1);//post1 is a object to copy an other object
        post1.showing_post();
        System.out.println("do you wanna make a comment 1.yes 2.no");
        input =scanner.nextInt();
        if(input==1){
            user.making_comment(post1,user);
        }

        System.out.println("do you wanna save the post 1.yes 2.no");
        input = scanner.nextInt();
        if(input==1){
            user.saving_post(post1);
        }
        post1.vote(user,post1);


    }

    public void making_post(){

        post post = new post();
        post.title_of_post = scanner.nextLine();
        post.text_of_post = scanner.nextLine();
        post.username = id;
        post.community_name = "its a personal post";
        show_user.add(post);
        User_posted.add(post);
    }
    public void making_post_in_community(){
        System.out.println("please enter the community name:");
        String name_community = scanner.next();
        for(community community:Communities){
            if(community.name.equals(name_community)){
                community1 = community;
            }
        }

        post post = new post();
        post.title_of_post = scanner.next();
        post.text_of_post = scanner.next();
        post.username = scanner.next();
        post.community_name = community1.name;
        show_user.add(post);
        User_posted.add(post);
        community1.post_community.add(post);


    }

    public void making_comment(post post , User user){
        comment comment = new comment();
        comment.username = user.id;
        System.out.println("write your comment");
        comment.text = scanner.next();
        post.Comment_of_Post.add(comment);
    }

    public void saving_post(post post){
        saved.add(post);
    }

    public void show_saved_post(){
        for(post post:saved){
            post.showing_post();
        }
    }

    public void making_community(User user){
        community community = new community();
        community.name = scanner.next();
        community.bio = scanner.nextLine();
        community.rules = scanner.nextLine();
        Main2.communities.add(community);
        community.admins.add(user);
    }
    static community community;
    public void join(User user){
        System.out.println("please enter the name of the community: ");
        String input = scanner.next();

        for(community community2:Communities){
            if(Objects.equals(community2.name, input)){
                community = community2;
            }
        }
        community.member.add(user);
        community.joined++;
    }
    public void show_voted_post(User user){
        int count =0;
        for(post post:voted){
            count++;
            System.out.println(count+post.username);
        }
        System.out.println("which post you want to see");
        int chose = scanner.nextInt();
        post post1 = voted.get(chose);
        post1.vote(user,post1);
        System.out.println("do you want to save the post 1.yes 2.no");
        chose = scanner.nextInt();
        if(chose==1){
            saving_post(post1);
        }
    }

}
