package com.scaler.libimgur.apis

import com.scaler.libimgur.ImgurClient
import com.scaler.libimgur.params.Section
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Test

class ImgurAPIv3Tests {
    val api = ImgurClient.api

    @Test
    fun `get tags working`() = runBlocking {
        val response = api.getTags()
        assertNotNull(response.body())

    }

    @Test
    fun `get galleries - hot working`() = runBlocking {
        val response = api.getGallery(Section.HOT)
        assertNotNull(response.body())
    }

    @Test
    fun `get galleries - top working`() = runBlocking {
        val response = api.getGallery(Section.TOP)
        assertNotNull(response.body())
    }

}