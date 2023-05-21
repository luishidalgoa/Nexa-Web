package Nexa.luishidalgoa.com.Nexa.Model.DTO;
import Nexa.luishidalgoa.com.Nexa.Model.Utils.Utils;
import Nexa.luishidalgoa.com.Nexa.Model.domain.publications.Publication;
import Nexa.luishidalgoa.com.Nexa.Model.domain.publications.Share;
import Nexa.luishidalgoa.com.Nexa.Model.domain.User.User;
import Nexa.luishidalgoa.com.Nexa.Model.domain.publications.likes;

import java.util.List;

public class publicationDTO {
    private User user;
    private Publication publication;
    private List<likes> likes;
    private List<Share> Share;
    private String beetwenDate;
    public publicationDTO(User user, Publication publication, List<likes> likes, List<Share> Share) {
        this.user = user;
        this.publication = publication;
        this.likes=likes;
        this.Share = Share;
        beetwenDate=Utils.calculateDifference(publication.getPublicationDate());
    }

    public User getUser() {
        return user;
    }

    public Publication getPublication() {
        return publication;
    }

    public List<likes> getLikes() {
        return likes;
    }
    public List<Share> getShares() {
        return Share;
    }

    public String getBeetwenDate() {
        return beetwenDate;
    }

    public void setBeetwenDate(String beetwenDate) {
        this.beetwenDate = beetwenDate;
    }
}
