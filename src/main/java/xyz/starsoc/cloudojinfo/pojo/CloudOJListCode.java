package xyz.starsoc.cloudojinfo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CloudOJListCode {
    private Integer count;
    private List<CloudOJCode> data;

    public CloudOJListCode(List<CloudOJCode> data) {
        this.count = data.size();
        this.data = data;
    }
}
