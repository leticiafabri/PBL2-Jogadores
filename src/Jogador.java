public class Jogador {

    private String nickname;
    private int ranking;

    public Jogador(String nickname, int ranking) {
        this.nickname = nickname;
        this.ranking = ranking;
    }

    public String getNickname() {
        return nickname;
    }

    public int getRanking() {
        return ranking;
    }
}