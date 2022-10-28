package com.gritacademy.canvasgritbackground

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi


class AlriksCanvas(context: Context) : View(context) {
    private lateinit var canvas: Canvas
    private lateinit var bitmap: Bitmap
    private var timer:Long = 0L
    private var pic: Bitmap =  BitmapFactory.decodeResource(getResources(), R.drawable.chloe_walk_15);
    var running:Boolean = false

    private var rand= kotlin.random.Random
    private var bgPiant= Paint().apply {
        textSize= 100f
        textAlign = Paint.Align.CENTER
        style=Paint.Style.FILL
        color=Color.WHITE
    }
    private var paint = Paint().apply {
        color = Color.BLACK
        isAntiAlias = true
        isDither = false
        textSize= 50f
        style = Paint.Style.FILL_AND_STROKE
        strokeWidth = 2f
        strokeCap = Paint.Cap.SQUARE
        strokeJoin = Paint.Join.MITER
    }
    var paint2: Paint = Paint().apply {
        color= Color.BLACK//resources.getColor(R.color.black)
        strokeWidth = 8f
        isAntiAlias = true
        textSize= 300f
        isDither = false
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.SQUARE
        strokeJoin = Paint.Join.MITER
    }
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
    var count:Float=0f
    var metrics: DisplayMetrics = context.getResources().getDisplayMetrics()
    var w:Float = metrics.widthPixels.toFloat()
    var h:Float = metrics.heightPixels.toFloat()
    //var dpi:Int = metrics.densityDpi

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (::bitmap.isInitialized) bitmap.recycle()
        bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
    }

    @SuppressLint("Range")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawBitmap(bitmap, 0f, 0f, null)
        //paint.color = Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255))
        //paint.color = Color.HSVToColor(floatArrayOf(0f,0f,Math.sin(count.toDouble()).toFloat()*0.95f))
        paint.color = Color.HSVToColor(floatArrayOf(Math.sin(count.toDouble()*0.2).toFloat()*122.5f+122.5f,1f,1f))

        paint.textSize = 200f;
        paint.alpha = 100;
        paint.strokeWidth= 10f;

        paint.apply {
            textSize = 200f
            alpha= 255
            strokeWidth = 10f
        }

        canvas?.apply {

            drawRect(0f, 0f,w,h,bgPiant) //vit rect bakgrund
            drawPoint(500f,300f,paint)
            drawArc(100F, 1200F,400f,1500f,0f,90f,false,paint)
            drawRect(100f,400f,300f,600f,paint)
            drawOval(600f,500f,800f,900f,paint)
            drawCircle(200f,800f,100f,paint)
            drawLine(0f, 0f, 200f, 200f, paint)
            drawText((-1).toString(),600f,1500f,paint2)
            drawBitmap(pic,400f,900f,paint)
            drawPath(path, paint)       //triangel
            drawText(count.toString(),300f,400f,paint)

        }
        paint.textSize=100f;
        canvas?.drawRect( 100f,1100f,1000f,1300f,paint)

        canvas?.drawText("Hello World!", 100f,1200f,bgPiant)
        canvas?.drawLine(50f,1500f,1200f,1500f,paint)
        count+=0.05f

    }
//    fun refresh(){
//        this.invalidate()
//    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        this.invalidate()
        return super.onTouchEvent(event)
    }

    override fun draw(canvas: Canvas) {
        invalidate()
        super.draw(canvas)
    }

//    override fun run() {
//        TODO("Not yet implemented")
//
//        while(running){
//            Thread.sleep(200)
//            refresh()
//        }
//    }

}