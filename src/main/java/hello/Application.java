package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Random;

@SpringBootApplication
@RestController
public class Application {

  static class Self {
    public String href;
  }

  static class Links {
    public Self self;
  }

  static class PlayerState {
    public Integer x;
    public Integer y;
    public String direction;
    public Boolean wasHit;
    public Integer score;
  }

  static class Arena {
    public List<Integer> dims;
    public Map<String, PlayerState> state;
  }

  static class ArenaUpdate {
    public Links _links;
    public Arena arena;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.initDirectFieldAccess();
  }

  @GetMapping("/")
  public String index() {
    return "Let the battle begin!";
  }

  @PostMapping("/**")
  public String index(@RequestBody ArenaUpdate arenaUpdate) {
    //System.out.println("arenaUpdate");

    //String[] moves = new String[]{"F", "R", "F", "L"};
    //int i = new Random().nextInt(4);
    String[] commands = new String[]{"F", "R", "T", "T", "T", "T", "T", "T", "T", "T", "F", "R","T", "T", "T", "T", "T", "T", "T", "T"};
    int j = new Random().nextInt(20);
    String[] command2 = new String[]{"R", "T", "T", "T", "T", "T", "T", "T", "T"};
    int k = new Random().nextInt(9);

    PlayerState playstate01 = arenaUpdate.arena.state.get("https://cloud-run-hackathon-java-springboot-4dnmcw5raa-uc.a.run.app");
    System.out.println("score: " + playstate01.score + " wasHit: " + playstate01.wasHit);
    
    // TODO add your implementation here to replace the random response. 
    //if(playstate01.wasHit == true)
    //    return moves[i];
    //else

    if(playstate01.x == 7 && playstate01.y == 5)
        return command2[k];
    else
        return commands[j];
    
  }

}

