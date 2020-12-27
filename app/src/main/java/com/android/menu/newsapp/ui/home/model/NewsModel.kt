package com.android.menu.newsapp.ui.home.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

/** Data classes for Xml data response **/

@Root(name = "rss", strict = false)
data class NewsResponseWrapper(
    @field: Element(name = "channel")
    var channel: NewsResponse? = null
)

@Root(name = "channel", strict = false)
data class NewsResponse(
    @field: ElementList(inline = true)
    var itemList: List<NewsItem>? = null
)

@Root(name = "item", strict = false)
data class NewsItem(
    @field: Element(name = "title")
    var title: String = "",
    @field: Element(name = "description", required = false)
    var description: String = "",
    @field: Element(name = "link")
    var link: String = "",
    @field: Element(name = "pubDate")
    var pubDate: String = ""
)