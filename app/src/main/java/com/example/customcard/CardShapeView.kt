package com.example.customcard

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet

class CardShapeView : ConstraintLayout {
    var colorCode = Color.WHITE
    var currentCard = 1

    constructor(context: Context?) : super(context)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyle: Int
    ) : super(context, attrs, defStyle)

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val triangleHeight = 80
        val w = width
        val h = height
        val path = Path()
        path.moveTo(0f, 0f)
        path.lineTo(0f, h - triangleHeight.toFloat())
        path.lineTo((w * 0.5).toFloat(), h.toFloat())
        path.lineTo(w.toFloat(), h - triangleHeight.toFloat())
        path.lineTo(w.toFloat(), 0f)
        path.lineTo(0f, 0f)
        path.close()
        val p = Paint()
        p.color = colorCode
        p.isAntiAlias = true
        canvas.drawPath(path, p)
    }

    companion object {
        var factorWidth = 0.75f
        var factorHeight = 0.75f
    }
}