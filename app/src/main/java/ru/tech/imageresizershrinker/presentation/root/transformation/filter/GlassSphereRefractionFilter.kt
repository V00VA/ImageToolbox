package ru.tech.imageresizershrinker.presentation.root.transformation.filter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.PointF
import jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter
import jp.co.cyberagent.android.gpuimage.filter.GPUImageGlassSphereFilter
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import ru.tech.imageresizershrinker.R
import ru.tech.imageresizershrinker.domain.image.filters.Filter

@Parcelize
class GlassSphereRefractionFilter(
    private val context: @RawValue Context,
    override val value: Pair<Float, Float> = 0.25f to 0.71f,
) : FilterTransformation<Pair<Float, Float>>(
    context = context,
    title = R.string.glass_sphere_refraction,
    value = value,
    paramsInfo = listOf(
        R.string.radius paramTo 0f..1f,
        R.string.refractive_index paramTo 0f..1f
    )
), Filter.GlassSphereRefraction<Bitmap> {
    override val cacheKey: String
        get() = (value to context).hashCode().toString()

    override fun createFilter(): GPUImageFilter = GPUImageGlassSphereFilter(
        PointF(0.5f, 0.5f),
        value.first, value.second
    )
}