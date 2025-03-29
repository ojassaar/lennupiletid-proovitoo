package lennud.backend.dto;

import java.util.List;

public class LendJaPiletid {
    
    private long lend;
    private List<Integer> piletid;

    public long getLend() {
        return lend;
    }
    
    public List<Integer> getPiletid() {
        return piletid;
    }
}
