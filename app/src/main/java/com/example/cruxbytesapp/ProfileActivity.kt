package com.example.cruxbytesapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GestureDetectorCompat
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment


//AIzaSyDOBpL-SiyQXcT7ytkc0juRFmqYnGmNijs    youtube api key
//kLBClA5nc5w

class ProfileActivity() : AppCompatActivity(),  YouTubePlayer.OnInitializedListener {
    companion object{
        var context: Context? = null
    }
    private val RECOVERY_DIALOG_REQUEST = 1
    private var gestureDetectorCompat: GestureDetectorCompat? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        var profilePage = findViewById<ConstraintLayout>(R.id.profile_page)
        context = applicationContext
        gestureDetectorCompat = GestureDetectorCompat(this, MyGestureListener())
//        val youTubePlayerFragment = supportFragmentManager.findFragmentById(R.id.official_player_view) as YouTubePlayerSupportFragment?
//        youTubePlayerFragment?.initialize("AIzaSyDOBpL-SiyQXcT7ytkc0juRFmqYnGmNijs", this)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gestureDetectorCompat!!.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

   internal class MyGestureListener() : SimpleOnGestureListener() {
        //handle 'swipe left' action only
        override fun onFling(
            event1: MotionEvent, event2: MotionEvent,
            velocityX: Float, velocityY: Float
        ): Boolean {


            if (event2.x < event1.x) {
                //switch another activity
                val intent = Intent(context, ActivityWebView::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context?.startActivity(intent)
            }
            return true
        }
    }

    override fun onInitializationSuccess(
        provider: YouTubePlayer.Provider,
        youTubePlayer: YouTubePlayer,
        wasRestored: Boolean
    ) {
        if (!wasRestored) {
            youTubePlayer.cueVideo("YE7VzlLtp-4")
        }
    }

    override fun onInitializationFailure(
        provider: YouTubePlayer.Provider,
        youTubeInitializationResult: YouTubeInitializationResult
    ) {
        if (youTubeInitializationResult.isUserRecoverableError) {
            youTubeInitializationResult.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show()
        } else {
            val errorMessage = String.format(
                "There was an error initializing the YouTubePlayer (%1\$s)",
                youTubeInitializationResult.toString()
            )
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
        }
    }
}