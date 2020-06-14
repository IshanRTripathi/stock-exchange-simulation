package Engine;

import Models.Order;
import Models.Trade;

import java.util.List;

public interface MatchingEngine {
    List<Trade> enterOrder(Order orderNew);
}
