package ru.tech.imageresizershrinker.presentation.root.transformation.filter

import android.content.Context
import android.graphics.Bitmap
import jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter
import jp.co.cyberagent.android.gpuimage.filter.GPUImageSketchFilter
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import ru.tech.imageresizershrinker.R
import ru.tech.imageresizershrinker.domain.image.filters.Filter

@Parcelize
class SketchFilter(
    private val context: @RawValue Context,
    override val value: Unit = Unit,
) : FilterTransformation<Unit>(
    context = context,
    title = R.string.sketch,
    value = value,
    valueRange = 0f..0f
), Filter.Sketch<Bitmap> {
    override val cacheKey: String
        get() = (value to context).hashCode().toString()

    override fun createFilter(): GPUImageFilter = GPUImageSketchFilter()
}