package com.example.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import java.util.*


class GameView(context: Context) : View(context)  {
    private val balls: MutableList<Ball> = ArrayList()
     init {
        balls.add(Ball(50f,50f,100f, Color.RED))
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (ball in balls) {
            ball.move(canvas)
            canvas.drawOval(ball.oval!!, ball.paint!!)
        }
        invalidate()
    }

}