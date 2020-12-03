package com.boot.gang.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface VolumePriceTrendService {

    Map<String, List> getVolumePriceTrend(HttpServletRequest request);
}
