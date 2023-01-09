package ua.in.ip.notespgs.entityes;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "images")
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private  String originalFileName;
    private Long size;
    private String contentType;
    private boolean previewImage;
    private byte[] bytes;
//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    private Note note;
}
