package com.example.magicball_student

import android.content.Context
import android.graphics.*
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import kotlin.random.Random

class GameView(context: Context, attrs: AttributeSet?) :
    SurfaceView(context, attrs),
    SensorEventListener,
    Runnable {

    // ============================================================
    // БЛОК 1: НАСТРОЙКИ ИГРЫ (ЗАМЕНИ ЗНАЧЕНИЯ)
    // ============================================================

    // TODO 1.1: Замени 0 на цвет (Color.RED, Color.BLUE, Color.GREEN и т.д.)
    private val BALL_COLOR = 0

    // TODO 1.2: Замени 0 на цвет (Color.GREEN, Color.YELLOW и т.д.)
    private val TARGET_COLOR = 0

    // TODO 1.3: Замени 0 на цвет (Color.BLACK, Color.DKGRAY и т.д.)
    private val BG_COLOR = 0

    // TODO 1.4: Замени 0f на число (рекомендуется 30f - 60f)
    private val BALL_RADIUS = 0f

    // TODO 1.5: Замени 0 на число (рекомендуется 3 - 10)
    private val TARGET_COUNT = 0

    // TODO 1.6: Замени 0f на число (0.1f - медленно, 0.5f - быстро)
    private val SENSITIVITY = 0f


    // ============================================================
    // БЛОК 2: ПЕРЕМЕННЫЕ ДЛЯ ИГРЫ (ЗАМЕНИ ЗНАЧЕНИЯ)
    // ============================================================

    // TODO 2.1: Замени 0f на число (например, 100f) — начальная позиция
    private var ballX = 0f
    private var ballY = 0f

    // TODO 2.2: Оставь 0f (начальная скорость)
    private var ballSpeedX = 0f
    private var ballSpeedY = 0f

    // TODO 2.3: Оставь как есть (список мишеней)
    private val targets = mutableListOf<Pair<Float, Float>>()

    // TODO 2.4: Оставь как есть (счёт и победа)
    private var score = 0
    private var gameWon = false


    // ============================================================
    // БЛОК 3: КИСТИ ДЛЯ РИСОВАНИЯ (РАСКОММЕНТИРУЙ ВЕСЬ БЛОК)
    // ============================================================

    // TODO 3: Удали /* в начале и */ в конце блока
    /*
    private val ballPaint = Paint().apply {
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    private val targetPaint = Paint().apply {
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    private val textPaint = Paint().apply {
        color = Color.WHITE
        textSize = 40f
        isAntiAlias = true
    }
    */


    // ============================================================
    // БЛОК 4: ПОДКЛЮЧЕНИЕ АКСЕЛЕРОМЕТРА (РАСКОММЕНТИРУЙ СТРОКИ)
    // ============================================================

    // TODO 4.1: Удали // в начале строки
    // private val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    // TODO 4.2: Удали // в начале строки
    // private val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)


    // ============================================================
    // БЛОК 5: ПОТОК ДЛЯ ИГРЫ (РАСКОММЕНТИРУЙ СТРОКИ)
    // ============================================================

    // TODO 5.1: Удали // в начале строки
    // private var thread: Thread? = null

    // TODO 5.2: Удали // в начале строки
    // private var isRunning = false


    // ============================================================
    // БЛОК 6: ИНИЦИАЛИЗАЦИЯ (РАСКОММЕНТИРУЙ ВЕСЬ БЛОК)
    // ============================================================

    // TODO 6: Удали /* в начале и */ в конце блока
    /*
    init {
        val screenWidth = resources.displayMetrics.widthPixels
        val screenHeight = resources.displayMetrics.heightPixels

        for (i in 0 until TARGET_COUNT) {
            val x = Random.nextFloat() * (screenWidth - 200f) + 100f
            val y = Random.nextFloat() * (screenHeight - 200f) + 100f
            targets.add(Pair(x, y))
        }

        holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceCreated(holder: SurfaceHolder) {
                startGame()
            }

            override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}

            override fun surfaceDestroyed(holder: SurfaceHolder) {
                stopGame()
            }
        })
    }
    */


    // ============================================================
    // БЛОК 7: МЕТОДЫ ЖИЗНЕННОГО ЦИКЛА (РАСКОММЕНТИРУЙ БЛОКИ)
    // ============================================================

    // TODO 7.1: Удали /* в начале и */ в конце блока
    /*
    private fun startGame() {
        if (thread == null) {
            isRunning = true
            thread = Thread(this)
            thread?.start()
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME)
        }
    }
    */

    // TODO 7.2: Удали /* в начале и */ в конце блока
    /*
    private fun stopGame() {
        isRunning = false
        thread?.join()
        thread = null
        sensorManager.unregisterListener(this)
    }
    */


    // ============================================================
    // БЛОК 8: ИГРОВОЙ ЦИКЛ (РАСКОММЕНТИРУЙ КОД ВНУТРИ МЕТОДОВ)
    // ============================================================

    // TODO 8.1: Удали /* и */ внутри метода run()
    override fun run() {
        /*
        while (isRunning) {
            update()
            draw()
            try {
                Thread.sleep(16)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        */
    }

    // TODO 8.2: Удали /* и */ внутри метода update()
    private fun update() {
        /*
        if (gameWon) return

        ballX += ballSpeedX
        ballY += ballSpeedY

        ballSpeedX *= 0.98f
        ballSpeedY *= 0.98f

        if (ballX - BALL_RADIUS < 0) {
            ballX = BALL_RADIUS
            ballSpeedX *= -0.5f
        }
        if (ballX + BALL_RADIUS > width) {
            ballX = width - BALL_RADIUS
            ballSpeedX *= -0.5f
        }
        if (ballY - BALL_RADIUS < 0) {
            ballY = BALL_RADIUS
            ballSpeedY *= -0.5f
        }
        if (ballY + BALL_RADIUS > height) {
            ballY = height - BALL_RADIUS
            ballSpeedY *= -0.5f
        }

        val toRemove = mutableListOf<Pair<Float, Float>>()
        for (target in targets) {
            val distance = Math.hypot(
                (ballX - target.first).toDouble(),
                (ballY - target.second).toDouble()
            )
            if (distance < BALL_RADIUS + 30f) {
                toRemove.add(target)
                score++
            }
        }
        targets.removeAll(toRemove)

        if (targets.isEmpty()) {
            gameWon = true
        }
        */
    }

    // TODO 8.3: Удали /* и */ внутри метода draw()
    private fun draw() {
        /*
        val holder = holder ?: return
        val canvas = holder.lockCanvas() ?: return

        canvas.drawColor(BG_COLOR)

        for (target in targets) {
            canvas.drawCircle(target.first, target.second, 30f, targetPaint)
        }

        ballPaint.color = BALL_COLOR
        canvas.drawCircle(ballX, ballY, BALL_RADIUS, ballPaint)

        canvas.drawText("Счёт: $score", 20f, 60f, textPaint)

        if (gameWon) {
            canvas.drawText("ПОБЕДА! 🎉", width / 2f - 120f, height / 2f, textPaint)
        }

        holder.unlockCanvasAndPost(canvas)
        */
    }


    // ============================================================
    // БЛОК 9: ОБРАБОТКА ДАТЧИКОВ (РАСКОММЕНТИРУЙ КОД ВНУТРИ)
    // ============================================================

    // TODO 9.1: Удали /* и */ внутри метода onSensorChanged()
    override fun onSensorChanged(event: SensorEvent?) {
        /*
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            ballSpeedX += event.values[0] * SENSITIVITY
            ballSpeedY -= event.values[1] * SENSITIVITY
        }
        */
    }

    // TODO 9.2: Удали /* и */ внутри метода onAccuracyChanged()
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        /*
        // Не используется
        */
    }
}