package com.mthree.engines;


import java.util.List;

import com.mthree.models.Order;
import com.mthree.models.Trade;

public interface MatchingEngine {
    List<Trade> enterOrder(Order orderNew);
}
