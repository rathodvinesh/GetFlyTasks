package com.learnvinesh.getflytasks.models

import android.widget.TextView

data class FAQQuestions(
    var question:String ?= null,
    var answer:String ?= null,
    var isExpandable:Boolean = false
)
