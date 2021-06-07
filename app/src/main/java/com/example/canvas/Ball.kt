package com.example.canvas

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import kotlin.random.Random


class Ball(x: Float, y: Float, size: Float, color: Int) {
    var direction = floatArrayOf(1.0f, 2.0f)
    var x = 0.0f
    var y = 0.0f
    var size = 0.0f
    var speed = 10.0f
    var paint: Paint? = null
    var oval: RectF? = null

    init {
        this.x = x
        this.y = y
        this.size = size
        paint = Paint()
        paint!!.color = color
    }

    fun move(canvas: Canvas) {
        this.x += speed * direction[0]
        this.y += speed * direction[1]
        oval = RectF(this.x - size / 2, this.y - size / 2, this.x + size / 2, this.y + size / 2)
        val bounds = Rect()
        oval!!.roundOut(bounds)
        if (!canvas.clipBounds.contains(bounds)) {
            if (this.x - size < 0 || this.x + size > canvas.width) {
                direction[1] = Random.nextDouble(-1.0,2.11).toFloat()
                direction[0] = direction[0] * -1.0f
            }
            if (this.y - size < 0 || this.y + size > canvas.height) {
                direction[1] = Random.nextDouble(1.0,1.12).toFloat()
                direction[1] = direction[1] * -1.0f
            }
        }
    }
}