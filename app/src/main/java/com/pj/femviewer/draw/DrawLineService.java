package com.pj.femviewer.draw;

public interface DrawLineService {
    void straightLine(int startX, int startY, int endX, int endY);
    void curvedLine(int startX, int startY, int endX, int endY);
}