package ua.in.ip.notespgs.entityes;

import jakarta.persistence.*;
import lombok.Data;
import ua.in.ip.notespgs.entityes.enums.Status;

@Entity
@Table(name = "notes")
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String heading; //рубрика
    private String description;
    private String body;
    private Status status;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;
}
