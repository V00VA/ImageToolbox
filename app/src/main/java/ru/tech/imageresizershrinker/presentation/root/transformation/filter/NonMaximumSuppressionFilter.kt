package ru.tech.imageresizershrinker.presentation.root.transformation.filter

import android.content.Context
import android.graphics.Bitmap
import jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter
import jp.co.cyberagent.android.gpuimage.filter.GPUImageNonMaximumSuppressionFilter
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import ru.tech.imageresizershrinker.R
import ru.tech.imageresizershrinker.domain.image.filters.Filter

@Parcelize
class NonMaximumSuppressionFilter(
    private val context: @RawValue Context,
) : FilterTransformation<Unit>(
    context = context,
    title = R.string.non_maximum_suppression,
    value = Unit
), Filter.NonMaximumSuppression<Bitmap> {
    override val cacheKey: String
        get() = (value to context).hashCode().toString()

    override fun createFilter(): GPUImageFilter = GPUImageNonMaximumSuppressionFilter()
}