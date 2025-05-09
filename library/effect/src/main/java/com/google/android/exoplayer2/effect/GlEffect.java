/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.android.exoplayer2.effect;

import android.content.Context;
import com.google.android.exoplayer2.util.Effect;
import com.google.android.exoplayer2.util.VideoFrameProcessingException;

/**
 * Interface for a video frame effect with a {@link GlShaderProgram} implementation.
 *
 * <p>Implementations contain information specifying the effect and can be {@linkplain
 * #toGlShaderProgram(Context, boolean) converted} to a {@link GlShaderProgram} which applies the
 * effect.
 *
 * @deprecated com.google.android.exoplayer2 is deprecated. Please migrate to androidx.media3 (which
 *     contains the same ExoPlayer code). See <a
 *     href="https://developer.android.com/guide/topics/media/media3/getting-started/migration-guide">the
 *     migration guide</a> for more details, including a script to help with the migration.
 */
@Deprecated
public interface GlEffect extends Effect {

  /**
   * Returns a {@link GlShaderProgram} that applies the effect.
   *
   * @param context A {@link Context}.
   * @param useHdr Whether input textures come from an HDR source. If {@code true}, colors will be
   *     in linear RGB BT.2020. If {@code false}, colors will be in linear RGB BT.709.
   * @throws VideoFrameProcessingException If an error occurs while creating the {@link
   *     GlShaderProgram}.
   */
  GlShaderProgram toGlShaderProgram(Context context, boolean useHdr)
      throws VideoFrameProcessingException;

  /**
   * Returns whether a {@link GlEffect} applies no change at every timestamp.
   *
   * <p>This can be used as a hint to skip this instance.
   *
   * @param inputWidth The input frame width, in pixels.
   * @param inputHeight The input frame height, in pixels.
   */
  default boolean isNoOp(int inputWidth, int inputHeight) {
    return false;
  }
}
