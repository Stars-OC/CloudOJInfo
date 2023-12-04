package xyz.starsoc.cloudojinfo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PageList<T> {
    private Integer count;
    private List<T> data;

    public PageList(List<T> data) {
        this.count = data.size();
        this.data = data;
    }
}
