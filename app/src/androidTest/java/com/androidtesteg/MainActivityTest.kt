package com.androidtesteg

import android.app.Activity.RESULT_OK
import android.app.Instrumentation
import android.content.ContentResolver
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.provider.MediaStore
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Matcher
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    //Here it not actually confirmed image choosen from Gallery
    //But it is image or type of image that expected to see

    //define for Intent test rule
    @get: Rule
    val intentsTest = IntentsTestRule(MainActivity::class.java)

    @Test
    fun test_validateGalleryIntent(){

        //Given
        val expectedIntent: Matcher<Intent> = allOf(
            hasAction(Intent.ACTION_PICK),          //Action
            hasData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI) //Data
        )

        val activityResult = createGalleryPickActivityResultStub()
        intending(expectedIntent).respondWith(activityResult)    //intending -> key word for testing Intent

        //Execute and Verify
        onView(withId(R.id.button_open_gallery)).perform(click())
        intended(expectedIntent)
    }

    private fun createGalleryPickActivityResultStub(): Instrumentation.ActivityResult {

        val resource: Resources = InstrumentationRegistry.getInstrumentation()   //use to retrieve context in test cases
            .context.resources

        val imageUrl = Uri.parse(
                    ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                            resource.getResourcePackageName(R.drawable.ic_launcher_background) + "/" +
                            resource.getResourceTypeName(R.drawable.ic_launcher_background) + "/" +
                            resource.getResourceEntryName(R.drawable.ic_launcher_background)
        )
        val resultIntent = Intent()
        resultIntent.setData(imageUrl)
        return  Instrumentation.ActivityResult(RESULT_OK,resultIntent)
    }

}