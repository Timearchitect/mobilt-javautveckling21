package com.gritacademy.canvasgritbackground

import android.graphics.*
import java.lang.Math.sin

class BgTriangle {
    val halfTriWidth= 200f
    var triHeight:Double = halfTriWidth*Math.sqrt(3.0)
    // triangel koordinater för punkter
    val point1: PointF = PointF(400f-halfTriWidth, 1800f)
    val point2: PointF = PointF(400f+halfTriWidth, 1800f)
    val point3: PointF = PointF(400f, 1800f-triHeight.toFloat())

    val path = Path().apply {
        setFillType(Path.FillType.EVEN_ODD)
        moveTo(point1.x , point1.y )
        lineTo(point2.x , point2.y )
        lineTo(point3.x , point3.y )
        lineTo(point1.x , point1.y )
        close()
    }
    val paint:Paint = Paint().apply {
        style=Paint.Style.FILL
        color= Color.BLACK
        isDither=false
        color= Color.BLACK

    }

    fun draw(canvas: Canvas,count:Float){
        paint.apply {
            color= Color.HSVToColor(floatArrayOf(0f,0f,sin(count.toDouble()).toFloat()))
        }
        canvas.drawPath(path,paint);

    }


}