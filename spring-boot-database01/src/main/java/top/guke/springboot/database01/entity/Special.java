package top.guke.springboot.database01.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Special {
    private String id;
    private String title;
    private String banner;
    private String introduction;
    private Integer viewCount;
    private Integer followersCount;
    private Long updated;
    private Boolean isFollowing;

    private List<Section> sections;

}
