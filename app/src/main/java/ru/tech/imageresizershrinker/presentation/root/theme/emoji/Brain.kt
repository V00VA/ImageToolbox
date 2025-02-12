package ru.tech.imageresizershrinker.presentation.root.theme.emoji

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.tech.imageresizershrinker.presentation.root.theme.Emoji

val Emoji.Brain: ImageVector
    get() {
        if (_brain != null) {
            return _brain!!
        }
        _brain = Builder(
            name = "Brain", defaultWidth = 1.0.dp, defaultHeight = 1.0.dp,
            viewportWidth = 128.0f, viewportHeight = 128.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFE06767)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(61.53f, 89.7f)
                reflectiveCurveToRelative(1.87f, 7.96f, 12.23f, 13.88f)
                curveToRelative(6.53f, 3.73f, 20.26f, 7.6f, 27.27f, 2.42f)
                curveToRelative(7.98f, -5.9f, 9.7f, -11.74f, 10.08f, -13.89f)
                curveToRelative(0.38f, -2.15f, -0.76f, -8.08f, -0.76f, -8.08f)
                lineToRelative(-13.13f, -4.67f)
                reflectiveCurveToRelative(-21.71f, 5.3f, -22.09f, 5.3f)
                curveToRelative(-0.37f, 0.01f, -13.6f, 5.04f, -13.6f, 5.04f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFB05353)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(110.39f, 94.67f)
                curveToRelative(0.29f, -0.75f, 0.47f, -1.39f, 0.6f, -1.92f)
                curveToRelative(-2.32f, -0.62f, -5.01f, -1.62f, -7.45f, -2.66f)
                curveToRelative(0.2f, -0.09f, 0.4f, -0.18f, 0.59f, -0.28f)
                curveToRelative(1.2f, -0.61f, 2.38f, -1.32f, 3.23f, -2.36f)
                curveToRelative(0.92f, -1.12f, 1.34f, -2.57f, 1.29f, -4.02f)
                lineToRelative(-11.43f, -4.07f)
                reflectiveCurveToRelative(-21.71f, 5.3f, -22.09f, 5.3f)
                curveToRelative(-0.38f, 0.0f, -13.6f, 5.03f, -13.61f, 5.04f)
                curveToRelative(-0.17f, 0.06f, 1.23f, 3.0f, 1.32f, 3.15f)
                curveToRelative(1.27f, 2.37f, 4.19f, 5.67f, 6.19f, 7.46f)
                curveToRelative(0.0f, 0.0f, -0.92f, -2.12f, 0.82f, -2.91f)
                curveToRelative(0.77f, -0.35f, 1.7f, -0.18f, 2.49f, 0.13f)
                curveToRelative(1.98f, 0.79f, 4.46f, 3.83f, 10.66f, 7.09f)
                curveToRelative(4.21f, 2.22f, 8.54f, 3.92f, 9.94f, 3.86f)
                curveToRelative(1.87f, -0.08f, 5.26f, -0.99f, 5.26f, -0.99f)
                reflectiveCurveToRelative(-4.32f, -0.41f, -11.26f, -3.64f)
                curveToRelative(-2.1f, -0.98f, -9.87f, -4.8f, -10.61f, -6.93f)
                curveToRelative(-0.21f, -0.6f, -0.96f, -1.66f, 0.4f, -2.26f)
                curveToRelative(2.08f, -0.93f, 7.75f, 3.96f, 12.62f, 6.2f)
                curveToRelative(5.8f, 2.66f, 12.12f, 4.79f, 12.12f, 4.79f)
                curveToRelative(0.68f, -0.52f, 1.32f, -1.04f, 1.92f, -1.56f)
                curveToRelative(-3.23f, -0.83f, -6.39f, -1.97f, -9.44f, -3.3f)
                curveToRelative(-3.04f, -1.32f, -6.02f, -3.03f, -8.77f, -4.91f)
                curveToRelative(-1.75f, -1.2f, -2.96f, -3.22f, -1.08f, -3.48f)
                curveToRelative(3.08f, -0.43f, 7.06f, 2.5f, 11.05f, 4.57f)
                curveToRelative(3.6f, 1.87f, 7.92f, 2.73f, 11.97f, 3.24f)
                curveToRelative(0.52f, -0.65f, 1.37f, -1.89f, 1.37f, -1.89f)
                reflectiveCurveToRelative(-1.53f, -0.26f, -6.05f, -1.26f)
                curveToRelative(-1.98f, -0.44f, -3.9f, -1.01f, -5.66f, -2.0f)
                curveToRelative(-0.46f, -0.26f, -2.07f, -1.91f, 0.13f, -2.67f)
                reflectiveCurveToRelative(4.29f, 0.75f, 7.61f, 1.52f)
                curveToRelative(3.33f, 0.79f, 5.84f, 0.83f, 5.87f, 0.76f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFB3B3)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(118.0f, 53.3f)
                reflectiveCurveToRelative(-0.25f, -8.1f, -4.6f, -15.27f)
                curveToRelative(-3.75f, -6.18f, -9.1f, -6.81f, -9.1f, -6.81f)
                reflectiveCurveToRelative(-1.06f, -3.89f, -4.78f, -6.87f)
                reflectiveCurveToRelative(-11.37f, -5.47f, -11.37f, -5.47f)
                curveToRelative(-15.32f, -6.9f, -24.87f, -1.25f, -24.87f, -1.25f)
                reflectiveCurveToRelative(-22.72f, -5.4f, -40.91f, 10.03f)
                curveToRelative(0.0f, 0.0f, -9.18f, 4.32f, -12.93f, 12.48f)
                curveToRelative(-2.07f, 4.52f, -1.18f, 11.89f, -1.18f, 11.89f)
                curveToRelative(-6.37f, 7.4f, -4.62f, 19.12f, 2.53f, 24.99f)
                curveToRelative(3.41f, 2.79f, 7.62f, 4.64f, 12.01f, 5.11f)
                curveToRelative(1.72f, 0.18f, 2.59f, -0.23f, 3.31f, 1.52f)
                curveToRelative(1.06f, 2.58f, 1.89f, 5.23f, 4.02f, 7.08f)
                curveToRelative(2.17f, 1.88f, 4.7f, 3.34f, 7.39f, 4.34f)
                curveToRelative(5.22f, 1.93f, 11.12f, 2.14f, 16.39f, 0.25f)
                curveToRelative(1.75f, -0.63f, 7.36f, -0.69f, 7.36f, -0.69f)
                reflectiveCurveToRelative(2.97f, 2.45f, 13.51f, 2.06f)
                reflectiveCurveToRelative(14.99f, -4.94f, 17.4f, -5.79f)
                curveToRelative(1.85f, -0.65f, 4.12f, -2.08f, 6.14f, -1.71f)
                curveToRelative(1.15f, 0.21f, 2.18f, 0.8f, 3.23f, 1.3f)
                curveToRelative(2.94f, 1.41f, 6.24f, 2.18f, 9.48f, 1.88f)
                curveToRelative(12.25f, -1.13f, 13.54f, -15.24f, 12.33f, -24.94f)
                curveTo(122.14f, 57.64f, 118.0f, 53.3f, 118.0f, 53.3f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFEA6363)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(27.52f, 72.45f)
                curveToRelative(-0.25f, 0.57f, -2.75f, 6.03f, -4.85f, 6.91f)
                curveToRelative(-3.63f, 1.53f, -9.25f, -2.11f, -11.4f, -3.11f)
                curveToRelative(-0.42f, -0.2f, -0.7f, 0.3f, -0.7f, 0.3f)
                curveToRelative(-0.35f, 0.45f, 0.56f, 1.38f, 1.02f, 1.71f)
                curveToRelative(1.78f, 1.28f, 6.05f, 4.18f, 9.22f, 4.97f)
                curveToRelative(4.09f, 1.02f, 7.16f, 0.0f, 7.16f, 0.0f)
                reflectiveCurveToRelative(1.12f, -8.19f, 1.21f, -8.56f)
                reflectiveCurveToRelative(0.0f, -3.63f, 0.0f, -3.63f)
                lineToRelative(-1.66f, 1.41f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFF07371)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(63.25f, 95.56f)
                reflectiveCurveToRelative(-2.06f, -0.32f, -5.22f, -0.27f)
                curveToRelative(-3.16f, 0.05f, -7.61f, 0.96f, -7.61f, 0.96f)
                reflectiveCurveToRelative(3.14f, -1.43f, 4.54f, -2.68f)
                curveToRelative(1.4f, -1.26f, 1.68f, -4.32f, 1.45f, -6.14f)
                curveToRelative(-0.24f, -1.86f, -0.87f, -2.8f, -5.63f, -3.79f)
                lineToRelative(14.26f, -0.79f)
                curveToRelative(-4.78f, 3.18f, -5.65f, 9.73f, -1.79f, 12.71f)
                close()
                moveTo(106.42f, 65.47f)
                curveToRelative(-2.48f, 0.33f, -4.89f, -0.14f, -7.03f, -1.41f)
                curveToRelative(-0.93f, -0.56f, -1.03f, -1.88f, -0.21f, -2.59f)
                curveToRelative(0.55f, -0.47f, 1.34f, -0.5f, 1.95f, -0.1f)
                curveToRelative(3.46f, 2.27f, 6.98f, 0.78f, 8.86f, -0.39f)
                curveToRelative(4.8f, -2.99f, 7.18f, -8.29f, 6.86f, -13.85f)
                curveToRelative(0.96f, 1.7f, 1.66f, 3.58f, 1.83f, 5.52f)
                curveToRelative(0.43f, 4.71f, -2.96f, 8.38f, -6.75f, 10.75f)
                curveToRelative(-1.81f, 1.14f, -3.68f, 1.83f, -5.51f, 2.07f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFF07371)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(117.14f, 70.16f)
                curveToRelative(-1.08f, 0.0f, -2.25f, -0.23f, -3.36f, -0.91f)
                curveToRelative(-1.14f, -0.7f, -1.78f, -1.64f, -2.35f, -2.8f)
                curveToRelative(-0.47f, -0.95f, -1.13f, -1.54f, -2.34f, -1.45f)
                curveToRelative(-0.85f, 0.07f, -1.67f, 0.55f, -2.52f, 0.43f)
                curveToRelative(1.13f, -2.0f, 2.94f, -3.6f, 5.07f, -4.47f)
                curveToRelative(0.98f, -0.4f, 2.08f, -0.65f, 3.08f, -0.34f)
                curveToRelative(0.11f, 0.7f, -0.36f, 1.35f, -0.63f, 2.01f)
                curveToRelative(-0.47f, 1.17f, -0.28f, 2.57f, 0.48f, 3.57f)
                curveToRelative(0.52f, 0.68f, 1.51f, 1.41f, 2.42f, 1.35f)
                curveToRelative(0.6f, -0.04f, 1.02f, -0.55f, 1.61f, -0.6f)
                curveToRelative(1.83f, -0.13f, 2.29f, 2.55f, 0.49f, 2.97f)
                curveToRelative(-0.58f, 0.14f, -1.24f, 0.24f, -1.95f, 0.24f)
                close()
                moveTo(99.54f, 33.08f)
                curveToRelative(-0.73f, 0.09f, -1.47f, 0.01f, -1.85f, -0.63f)
                curveToRelative(-0.49f, -0.83f, -0.08f, -1.87f, 0.83f, -2.19f)
                curveToRelative(2.51f, -0.88f, 5.33f, -0.72f, 7.78f, 0.26f)
                curveToRelative(2.14f, 0.86f, 3.43f, 2.32f, 4.28f, 3.31f)
                curveToRelative(0.85f, 0.99f, 1.43f, 2.95f, 1.43f, 2.95f)
                curveToRelative(-2.13f, -1.85f, -3.34f, -4.76f, -12.47f, -3.7f)
                close()
                moveTo(89.96f, 31.15f)
                curveToRelative(-2.16f, -0.09f, -0.06f, 0.0f, -0.08f, 0.0f)
                curveToRelative(-3.42f, 0.0f, -7.51f, -1.18f, -8.06f, -5.08f)
                curveToRelative(-0.99f, -7.1f, 9.49f, -4.34f, 13.33f, -3.81f)
                curveToRelative(0.0f, 0.0f, -3.03f, -3.11f, -7.0f, -3.38f)
                curveToRelative(-1.85f, -0.12f, -3.76f, -0.07f, -5.56f, 0.41f)
                curveToRelative(-1.98f, 0.53f, -2.98f, 2.02f, -4.78f, 2.76f)
                curveToRelative(-1.36f, 0.55f, -2.91f, 0.34f, -4.31f, -0.08f)
                curveToRelative(-1.29f, -0.39f, -5.48f, -2.64f, -5.6f, 0.16f)
                curveToRelative(-0.03f, 0.77f, 0.52f, 1.43f, 1.27f, 1.54f)
                curveToRelative(3.04f, 0.43f, 7.24f, 1.79f, 8.8f, 4.69f)
                curveToRelative(0.72f, 1.33f, 0.89f, 2.94f, 0.47f, 4.39f)
                curveToRelative(-0.2f, 0.71f, -0.49f, 1.62f, 0.1f, 2.07f)
                curveToRelative(0.45f, 0.35f, 1.14f, 0.12f, 1.55f, -0.28f)
                curveToRelative(0.41f, -0.4f, 0.67f, -0.94f, 1.08f, -1.34f)
                curveToRelative(1.28f, -1.26f, 2.44f, -0.36f, 3.8f, 0.12f)
                curveToRelative(1.57f, 0.56f, 3.23f, 0.83f, 4.9f, 0.83f)
                curveToRelative(0.04f, 0.0f, -2.93f, -0.29f, 0.11f, 0.0f)
                curveToRelative(3.03f, 0.28f, 2.13f, -2.91f, -0.02f, -3.0f)
                close()
                moveTo(41.89f, 27.89f)
                curveToRelative(-1.66f, -1.5f, -2.45f, -7.34f, 2.32f, -10.35f)
                curveToRelative(0.0f, 0.0f, -2.6f, 0.09f, -4.77f, 1.79f)
                curveToRelative(-1.85f, 1.45f, -2.22f, 3.96f, -1.78f, 6.61f)
                curveToRelative(0.11f, 0.68f, -0.42f, 1.3f, -1.11f, 1.26f)
                curveToRelative(-2.48f, -0.13f, -4.95f, 0.32f, -7.08f, 1.3f)
                curveToRelative(-0.81f, 0.38f, -1.09f, 1.4f, -0.61f, 2.16f)
                arcToRelative(1.5f, 1.5f, 0.0f, false, false, 1.91f, 0.54f)
                curveToRelative(2.39f, -1.1f, 5.87f, -1.69f, 8.66f, -0.99f)
                curveToRelative(2.83f, 0.71f, 4.82f, 1.53f, 7.04f, 5.38f)
                curveToRelative(0.38f, 0.65f, 1.2f, 0.88f, 1.82f, 0.46f)
                curveToRelative(0.48f, -0.33f, 0.68f, -0.95f, 0.48f, -1.49f)
                curveToRelative(-1.9f, -5.24f, -4.64f, -4.65f, -6.88f, -6.67f)
                close()
                moveTo(48.08f, 45.9f)
                arcToRelative(1.496f, 1.496f, 0.0f, false, false, -1.87f, -1.03f)
                curveToRelative(-2.4f, 0.72f, -5.87f, 0.51f, -7.42f, -1.05f)
                curveToRelative(-2.07f, -4.79f, -3.64f, -5.64f, -6.15f, -6.49f)
                curveToRelative(-1.0f, -0.34f, -2.0f, 0.52f, -1.9f, 1.56f)
                curveToRelative(0.06f, 0.59f, 0.45f, 1.09f, 1.02f, 1.26f)
                curveToRelative(1.78f, 0.53f, 3.57f, 2.92f, 4.49f, 5.36f)
                curveToRelative(0.84f, 2.21f, 0.94f, 5.12f, -0.96f, 7.2f)
                curveToRelative(-0.49f, 0.54f, -0.59f, 1.32f, -0.16f, 1.91f)
                lineToRelative(0.02f, 0.03f)
                curveToRelative(0.55f, 0.76f, 1.65f, 0.82f, 2.29f, 0.13f)
                curveToRelative(0.68f, -0.74f, 1.39f, -1.7f, 1.69f, -2.67f)
                curveToRelative(0.31f, -1.03f, 0.22f, -1.95f, 1.11f, -2.77f)
                curveToRelative(0.99f, -0.92f, 1.93f, -0.73f, 3.12f, -0.73f)
                curveToRelative(1.22f, 0.0f, 2.53f, -0.44f, 3.68f, -0.85f)
                curveToRelative(0.78f, -0.25f, 1.28f, -1.08f, 1.04f, -1.86f)
                close()
                moveTo(17.42f, 59.46f)
                curveToRelative(-0.34f, 0.0f, -0.67f, -0.01f, -1.02f, -0.04f)
                curveToRelative(-4.63f, -0.4f, -7.06f, -3.73f, -8.16f, -7.38f)
                reflectiveCurveToRelative(-0.17f, -7.62f, -0.17f, -7.62f)
                curveToRelative(1.4f, 10.8f, 7.03f, 11.87f, 8.59f, 12.01f)
                curveToRelative(2.95f, 0.26f, 5.77f, -1.02f, 6.54f, -2.97f)
                curveToRelative(1.22f, -3.08f, -2.52f, -6.1f, -4.35f, -7.97f)
                curveToRelative(-1.21f, -1.24f, -1.66f, -3.35f, -1.34f, -5.02f)
                curveToRelative(0.16f, -0.86f, 0.54f, -1.7f, 1.25f, -2.25f)
                curveToRelative(0.7f, -0.54f, 2.46f, -1.03f, 2.22f, 0.51f)
                curveToRelative(-0.07f, 0.48f, -0.38f, 0.88f, -0.57f, 1.32f)
                curveToRelative(-1.37f, 3.12f, 3.5f, 6.01f, 4.83f, 8.32f)
                curveToRelative(1.09f, 1.87f, 1.57f, 4.13f, 0.75f, 6.19f)
                curveToRelative(-1.16f, 2.94f, -4.67f, 4.9f, -8.57f, 4.9f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFF07371)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(16.35f, 58.66f)
                curveToRelative(0.81f, 0.1f, 1.64f, -0.04f, 2.37f, -0.4f)
                curveToRelative(0.7f, -0.34f, 1.33f, -0.88f, 2.1f, -0.94f)
                curveToRelative(0.37f, -0.02f, 0.83f, 0.2f, 0.77f, 0.56f)
                curveToRelative(-0.02f, 0.13f, 0.83f, 0.37f, 0.72f, 0.44f)
                curveToRelative(-1.99f, 1.24f, -7.03f, 2.47f, -3.55f, 11.4f)
                curveToRelative(0.28f, 0.71f, 0.06f, 1.51f, -0.59f, 1.9f)
                curveToRelative(-0.76f, 0.46f, -1.77f, 0.16f, -2.13f, -0.65f)
                curveToRelative(-0.95f, -2.09f, -1.41f, -4.4f, -1.38f, -6.7f)
                curveToRelative(0.03f, -2.24f, 0.26f, -4.2f, -1.24f, -6.07f)
                curveToRelative(-0.16f, -0.19f, -0.33f, -0.46f, -0.2f, -0.67f)
                curveToRelative(0.08f, -0.13f, 0.24f, -0.18f, 0.39f, -0.22f)
                curveToRelative(0.62f, -0.16f, 1.28f, -0.33f, 1.91f, -0.2f)
                curveToRelative(0.28f, 0.06f, 3.41f, 1.79f, 3.44f, 1.73f)
                moveToRelative(86.6f, 14.26f)
                curveToRelative(-2.07f, -0.25f, -4.2f, -0.1f, -6.16f, 0.64f)
                curveToRelative(-1.66f, 0.63f, -2.9f, 1.9f, -4.81f, 1.48f)
                curveToRelative(-1.14f, -0.25f, -2.15f, -0.98f, -2.86f, -1.91f)
                curveToRelative(-1.5f, -1.95f, -1.3f, -4.0f, -0.74f, -6.22f)
                curveToRelative(0.56f, -2.2f, 0.5f, -4.75f, -0.49f, -6.82f)
                curveToRelative(-0.26f, -0.55f, -0.7f, -1.04f, -1.27f, -1.24f)
                curveToRelative(-0.58f, -0.2f, -1.29f, -0.03f, -1.63f, 0.48f)
                curveToRelative(-0.34f, 0.52f, -0.21f, 1.21f, -0.09f, 1.82f)
                curveToRelative(0.39f, 1.87f, 0.89f, 3.89f, 0.33f, 5.72f)
                curveToRelative(-0.53f, 1.74f, -1.26f, 3.3f, -2.51f, 4.64f)
                curveToRelative(-2.37f, 2.55f, -5.81f, 3.72f, -8.78f, 2.97f)
                curveToRelative(-2.19f, -0.55f, -3.96f, -2.08f, -5.15f, -4.42f)
                curveToRelative(-0.42f, -1.83f, -0.86f, -4.21f, -3.13f, -4.47f)
                curveToRelative(-0.46f, -0.05f, -0.96f, 0.02f, -1.31f, 0.31f)
                curveToRelative(-0.35f, 0.3f, -0.51f, 0.78f, -0.51f, 1.24f)
                curveToRelative(0.0f, 1.15f, 1.1f, 2.01f, 1.3f, 3.14f)
                curveToRelative(0.63f, 3.46f, -1.67f, 7.42f, -5.16f, 9.34f)
                curveToRelative(-2.7f, 1.49f, -10.11f, 2.33f, -16.75f, -3.24f)
                curveToRelative(-0.28f, -0.24f, -0.28f, -0.7f, -0.55f, -0.95f)
                curveToRelative(-0.18f, -0.16f, -0.41f, -0.26f, -0.64f, -0.3f)
                curveToRelative(-0.99f, -0.19f, -2.02f, 0.75f, -1.93f, 1.75f)
                curveToRelative(0.08f, 0.91f, 0.83f, 1.61f, 1.5f, 2.23f)
                curveToRelative(1.74f, 1.62f, 0.96f, 2.27f, 0.66f, 3.14f)
                curveToRelative(-0.07f, 0.22f, -0.2f, 0.42f, -0.22f, 0.65f)
                curveToRelative(-0.06f, 0.64f, 0.92f, 0.43f, 1.56f, 0.38f)
                curveToRelative(0.64f, -0.05f, 1.22f, -0.4f, 1.84f, -0.58f)
                curveToRelative(0.78f, -0.22f, 4.35f, 1.09f, 5.05f, 1.24f)
                curveToRelative(2.03f, 0.44f, 2.73f, 0.64f, 4.48f, 0.64f)
                curveToRelative(2.19f, 0.0f, 4.05f, 1.13f, 5.65f, -0.37f)
                curveToRelative(2.28f, -2.13f, 4.05f, -3.52f, 6.07f, -4.21f)
                curveToRelative(1.0f, -0.34f, 2.2f, -0.51f, 3.04f, 0.14f)
                curveToRelative(0.6f, 0.46f, 0.87f, 1.23f, 1.08f, 1.95f)
                curveToRelative(0.43f, 1.48f, 0.75f, 2.99f, 1.38f, 4.4f)
                curveToRelative(0.63f, 1.4f, 1.63f, 2.71f, 3.03f, 3.34f)
                curveToRelative(0.44f, 0.2f, 0.94f, 0.33f, 1.42f, 0.22f)
                reflectiveCurveToRelative(0.9f, -0.52f, 0.91f, -1.0f)
                curveToRelative(0.01f, -0.33f, -0.16f, -0.63f, -0.34f, -0.9f)
                curveToRelative(-0.69f, -1.1f, -1.51f, -2.12f, -2.12f, -3.26f)
                curveToRelative(-0.61f, -1.14f, -1.01f, -2.47f, -0.76f, -3.74f)
                curveToRelative(0.46f, -2.35f, 3.18f, -3.01f, 5.13f, -3.6f)
                curveToRelative(1.87f, -0.57f, 3.74f, -1.64f, 5.75f, -1.53f)
                curveToRelative(1.26f, 0.07f, 3.93f, 1.54f, 4.73f, 2.52f)
                curveToRelative(0.16f, 0.2f, 0.23f, 0.45f, 0.27f, 0.71f)
                curveToRelative(0.34f, 2.11f, -1.21f, 4.01f, -2.68f, 5.55f)
                curveToRelative(-0.26f, 0.27f, -0.53f, 0.68f, -0.31f, 0.99f)
                curveToRelative(0.08f, 0.11f, 0.2f, 0.17f, 0.32f, 0.21f)
                curveToRelative(1.06f, 0.41f, 2.3f, 0.05f, 3.2f, -0.64f)
                curveToRelative(1.98f, -1.5f, 2.67f, -4.07f, 4.36f, -5.85f)
                curveToRelative(1.39f, -1.45f, 3.26f, -2.4f, 5.15f, -3.02f)
                curveToRelative(6.76f, -2.22f, 7.11f, 3.1f, 8.32f, 6.08f)
                reflectiveCurveToRelative(3.0f, 0.92f, 3.02f, 0.1f)
                curveToRelative(0.07f, -3.89f, -2.42f, -9.01f, -8.65f, -9.75f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFF07371)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(42.25f, 88.89f)
                curveToRelative(-1.03f, -0.06f, -1.71f, -1.13f, -1.29f, -2.08f)
                curveToRelative(0.67f, -1.52f, 1.93f, -3.03f, 3.56f, -4.19f)
                curveToRelative(2.48f, -1.76f, 4.96f, -2.08f, 7.45f, -1.37f)
                lineToRelative(0.51f, 2.54f)
                curveToRelative(-1.61f, -0.46f, -4.49f, 0.05f, -6.22f, 1.28f)
                curveToRelative(-1.25f, 0.89f, -2.11f, 1.98f, -2.53f, 2.89f)
                curveToRelative(-0.27f, 0.59f, -0.84f, 0.97f, -1.48f, 0.93f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFEA6363)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(107.01f, 42.8f)
                curveToRelative(-0.19f, -1.27f, -1.18f, -2.45f, -2.46f, -2.49f)
                curveToRelative(-0.63f, -0.02f, -1.33f, 0.31f, -1.5f, 0.92f)
                curveToRelative(-0.08f, 0.27f, -0.04f, 0.57f, -0.03f, 0.85f)
                curveToRelative(0.08f, 2.08f, -1.59f, 4.09f, -3.65f, 4.38f)
                curveToRelative(-2.33f, 0.33f, -4.05f, -1.11f, -5.81f, -2.31f)
                curveToRelative(-1.68f, -1.14f, -3.78f, -1.91f, -5.72f, -2.46f)
                curveToRelative(-5.17f, -1.45f, -9.62f, -0.48f, -13.01f, 3.79f)
                curveToRelative(-1.26f, 1.59f, -2.46f, 3.33f, -4.23f, 4.31f)
                curveToRelative(-2.78f, 1.54f, -8.65f, 1.65f, -10.38f, -1.37f)
                curveToRelative(-2.27f, -3.95f, -2.35f, -16.09f, 4.93f, -14.71f)
                curveToRelative(2.25f, 0.43f, 3.92f, 2.38f, 4.08f, 3.83f)
                curveToRelative(0.1f, 0.92f, -0.47f, 1.72f, -1.2f, 2.34f)
                arcToRelative(1.49f, 1.49f, 0.0f, false, false, -0.3f, 1.91f)
                curveToRelative(0.48f, 0.79f, 1.56f, 0.96f, 2.26f, 0.37f)
                curveToRelative(2.05f, -1.76f, 2.37f, -3.61f, 2.22f, -4.95f)
                curveToRelative(-0.47f, -4.27f, -5.28f, -6.68f, -9.1f, -6.79f)
                curveToRelative(-0.84f, -0.03f, -1.81f, -0.3f, -2.13f, -1.09f)
                curveToRelative(-0.14f, -0.34f, -0.12f, -0.71f, -0.15f, -1.07f)
                curveToRelative(-0.2f, -2.55f, -2.81f, -5.32f, -4.85f, -6.64f)
                curveToRelative(-0.75f, -0.49f, -1.76f, -0.17f, -2.15f, 0.63f)
                curveToRelative(-0.33f, 0.69f, -0.07f, 1.5f, 0.57f, 1.92f)
                curveToRelative(1.94f, 1.28f, 3.12f, 3.14f, 3.51f, 5.54f)
                curveToRelative(0.44f, 2.76f, -0.16f, 5.58f, -1.32f, 8.09f)
                curveToRelative(-0.58f, 1.26f, -1.29f, 2.48f, -2.12f, 3.6f)
                curveToRelative(-0.71f, 0.97f, -1.72f, 1.62f, -2.18f, 2.78f)
                curveToRelative(-0.05f, 0.13f, -0.1f, 0.27f, -0.06f, 0.4f)
                curveToRelative(0.07f, 0.25f, 0.38f, 0.32f, 0.64f, 0.33f)
                curveToRelative(0.74f, 0.03f, 1.48f, -0.13f, 2.14f, -0.44f)
                curveToRelative(-0.38f, 1.47f, 0.6f, 2.9f, 1.41f, 4.18f)
                curveToRelative(0.81f, 1.28f, 1.46f, 3.02f, 0.54f, 4.23f)
                curveToRelative(-0.04f, 0.05f, -0.09f, 0.1f, -0.13f, 0.16f)
                curveToRelative(-1.97f, 0.83f, -3.87f, 1.96f, -5.35f, 3.52f)
                curveToRelative(-2.55f, 2.7f, -4.44f, 5.13f, -8.17f, 6.33f)
                curveToRelative(-3.3f, 1.07f, -6.97f, 0.94f, -10.18f, -0.35f)
                curveToRelative(-0.62f, -0.25f, -1.25f, -0.54f, -1.92f, -0.52f)
                curveToRelative(-0.67f, 0.02f, -1.38f, 0.49f, -1.4f, 1.16f)
                curveToRelative(-0.01f, 0.34f, 0.16f, 0.65f, 0.31f, 0.96f)
                curveToRelative(1.7f, 3.45f, -1.42f, 5.69f, -2.75f, 8.69f)
                curveToRelative(-1.25f, 2.8f, -1.89f, 5.87f, -1.89f, 8.94f)
                curveToRelative(0.0f, 3.35f, 1.15f, 5.79f, 5.3f, 10.05f)
                curveToRelative(1.88f, 1.92f, 4.34f, 3.06f, 6.41f, 3.73f)
                curveToRelative(0.65f, 0.21f, 1.06f, -0.68f, 0.48f, -1.05f)
                curveToRelative(-4.27f, -2.72f, -4.94f, -5.13f, -6.24f, -7.61f)
                curveToRelative(-3.12f, -5.97f, 0.29f, -15.07f, 6.16f, -19.69f)
                curveToRelative(2.27f, -1.78f, 5.49f, -1.64f, 8.23f, -0.7f)
                curveToRelative(2.94f, 1.01f, 4.68f, 3.17f, 6.89f, 5.18f)
                curveToRelative(0.6f, 0.55f, 1.37f, 1.14f, 2.14f, 0.9f)
                curveToRelative(0.7f, -0.21f, 1.05f, -1.04f, 0.97f, -1.76f)
                curveToRelative(-0.08f, -0.72f, -0.49f, -1.36f, -0.88f, -1.97f)
                curveToRelative(-0.43f, -0.67f, -0.86f, -1.34f, -1.3f, -2.01f)
                curveToRelative(-0.57f, -0.88f, -1.16f, -1.8f, -1.34f, -2.84f)
                curveToRelative(-0.2f, -1.13f, 0.8f, -5.04f, 10.3f, -7.46f)
                curveToRelative(1.61f, -0.41f, 3.25f, -0.23f, 4.87f, 0.23f)
                curveToRelative(2.18f, 0.62f, 3.74f, 2.22f, 5.57f, 3.47f)
                curveToRelative(0.51f, 0.35f, 1.07f, 0.72f, 1.69f, 0.74f)
                curveToRelative(0.78f, 0.03f, 1.54f, -0.56f, 1.7f, -1.33f)
                curveToRelative(0.22f, -1.06f, -0.58f, -2.01f, -1.11f, -2.95f)
                curveToRelative(-1.76f, -3.1f, 0.29f, -7.24f, 2.88f, -9.22f)
                curveToRelative(2.32f, -1.76f, 5.37f, -2.41f, 8.26f, -2.11f)
                curveToRelative(4.4f, 0.45f, 8.74f, 3.39f, 9.75f, 7.69f)
                curveToRelative(0.23f, 0.97f, 0.51f, 2.22f, 1.5f, 2.35f)
                curveToRelative(1.1f, 0.15f, 1.69f, -1.32f, 1.58f, -2.43f)
                reflectiveCurveToRelative(-0.47f, -2.36f, 0.22f, -3.24f)
                curveToRelative(0.32f, -0.4f, 0.8f, -0.63f, 1.27f, -0.84f)
                curveToRelative(1.35f, -0.59f, 2.76f, -1.08f, 3.97f, -1.93f)
                curveToRelative(1.21f, -0.84f, 2.22f, -2.13f, 2.31f, -3.6f)
                curveToRelative(-0.01f, -0.17f, -0.02f, -0.37f, -0.05f, -0.57f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFF07371)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(52.86f, 44.9f)
                curveToRelative(0.74f, 0.03f, 1.48f, -0.13f, 2.14f, -0.44f)
                curveToRelative(-0.38f, 1.47f, 0.6f, 2.9f, 1.41f, 4.18f)
                curveToRelative(0.59f, 0.94f, 1.41f, 2.61f, 0.52f, 4.32f)
                curveToRelative(0.0f, 0.0f, 1.34f, -0.75f, 3.51f, -1.38f)
                reflectiveCurveToRelative(4.29f, -0.77f, 4.29f, -0.77f)
                curveToRelative(-1.54f, -0.32f, -3.82f, -1.19f, -4.52f, -2.4f)
                curveToRelative(-2.27f, -3.95f, -2.35f, -16.09f, 4.93f, -14.71f)
                curveToRelative(2.25f, 0.43f, 3.92f, 2.38f, 4.08f, 3.83f)
                curveToRelative(0.1f, 0.92f, -0.47f, 1.72f, -1.2f, 2.34f)
                arcToRelative(1.49f, 1.49f, 0.0f, false, false, -0.3f, 1.91f)
                curveToRelative(0.48f, 0.79f, 1.56f, 0.96f, 2.26f, 0.37f)
                curveToRelative(2.05f, -1.76f, 2.37f, -3.61f, 2.22f, -4.95f)
                curveToRelative(-0.47f, -4.27f, -5.28f, -6.68f, -9.1f, -6.79f)
                curveToRelative(-0.84f, -0.03f, -1.81f, -0.3f, -2.13f, -1.09f)
                curveToRelative(-0.14f, -0.34f, -0.12f, -0.71f, -0.15f, -1.07f)
                curveToRelative(-0.2f, -2.55f, -2.81f, -5.32f, -4.85f, -6.64f)
                curveToRelative(-0.75f, -0.49f, -1.76f, -0.17f, -2.15f, 0.63f)
                curveToRelative(-0.33f, 0.69f, -0.07f, 1.5f, 0.57f, 1.92f)
                curveToRelative(1.94f, 1.28f, 3.12f, 3.14f, 3.51f, 5.54f)
                curveToRelative(0.44f, 2.76f, -0.16f, 5.58f, -1.32f, 8.09f)
                curveToRelative(-0.58f, 1.26f, -1.29f, 2.48f, -2.12f, 3.6f)
                curveToRelative(-0.71f, 0.97f, -1.72f, 1.62f, -2.18f, 2.78f)
                curveToRelative(-0.05f, 0.13f, -0.1f, 0.27f, -0.06f, 0.4f)
                curveToRelative(0.07f, 0.25f, 0.38f, 0.32f, 0.64f, 0.33f)
                close()
            }
        }
            .build()
        return _brain!!
    }

private var _brain: ImageVector? = null
