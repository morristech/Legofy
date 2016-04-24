package com.jeroenmols.legofy;

import android.content.res.Resources;
import android.graphics.Bitmap;

/**
 * @author Jeroen Mols on 23/04/16.
 */
public class Legofy {

    private final int bricksInWidth;
    private BrickDrawer brickDrawer;
    private final BitmapWrapper bitmapWrapper;

    public Legofy(int bricksInWidth) {
        this(new BitmapWrapper(), new BrickDrawer(), bricksInWidth);
    }

    protected Legofy(BitmapWrapper bitmapWrapper, BrickDrawer brickDrawer, int bricksInWidth) {
        this.bitmapWrapper = bitmapWrapper;
        this.brickDrawer = brickDrawer;
        this.bricksInWidth = bricksInWidth;
    }

    public Bitmap processBitmap(Resources resources, Bitmap bitmap) {
        int brickSize = bitmap.getWidth() / bricksInWidth;

        int width = brickSize * bricksInWidth;
        int height = (bitmap.getHeight() / brickSize) * brickSize;

        Bitmap processedBitmap = bitmapWrapper.createBitmap(width, height, null);
        brickDrawer.setBitmap(resources, processedBitmap, brickSize);

        brickDrawer.drawBrick(0, 0, 0, brickSize);
        return processedBitmap;
    }
}