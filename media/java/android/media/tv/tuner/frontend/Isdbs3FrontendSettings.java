/*
 * Copyright 2019 The Android Open Source Project
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

package android.media.tv.tuner.frontend;

import android.annotation.IntDef;
import android.annotation.NonNull;
import android.annotation.RequiresPermission;
import android.content.Context;
import android.hardware.tv.tuner.V1_0.Constants;
import android.media.tv.tuner.TunerUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Frontend settings for ISDBS-3.
 * @hide
 */
public class Isdbs3FrontendSettings extends FrontendSettings {
    /** @hide */
    @IntDef(flag = true,
            prefix = "MODULATION_",
            value = {MODULATION_UNDEFINED, MODULATION_AUTO, MODULATION_MOD_BPSK,
            MODULATION_MOD_QPSK, MODULATION_MOD_8PSK, MODULATION_MOD_16APSK,
            MODULATION_MOD_32APSK})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Modulation {}

    /**
     * Modulation undefined.
     */
    public static final int MODULATION_UNDEFINED = Constants.FrontendIsdbs3Modulation.UNDEFINED;
    /**
     * Hardware is able to detect and set modulation automatically.
     */
    public static final int MODULATION_AUTO = Constants.FrontendIsdbs3Modulation.AUTO;
    /**
     * BPSK Modulation.
     */
    public static final int MODULATION_MOD_BPSK = Constants.FrontendIsdbs3Modulation.MOD_BPSK;
    /**
     * QPSK Modulation.
     */
    public static final int MODULATION_MOD_QPSK = Constants.FrontendIsdbs3Modulation.MOD_QPSK;
    /**
     * 8PSK Modulation.
     */
    public static final int MODULATION_MOD_8PSK = Constants.FrontendIsdbs3Modulation.MOD_8PSK;
    /**
     * 16APSK Modulation.
     */
    public static final int MODULATION_MOD_16APSK = Constants.FrontendIsdbs3Modulation.MOD_16APSK;
    /**
     * 32APSK Modulation.
     */
    public static final int MODULATION_MOD_32APSK = Constants.FrontendIsdbs3Modulation.MOD_32APSK;

    /** @hide */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef(flag = true,
            prefix = "CODERATE_",
            value = {CODERATE_UNDEFINED, CODERATE_AUTO, CODERATE_1_3, CODERATE_2_5, CODERATE_1_2,
                    CODERATE_3_5, CODERATE_2_3, CODERATE_3_4, CODERATE_7_9, CODERATE_4_5,
                    CODERATE_5_6, CODERATE_7_8, CODERATE_9_10})
    public @interface Coderate {}

    /**
     * Code rate undefined.
     */
    public static final int CODERATE_UNDEFINED = Constants.FrontendIsdbs3Coderate.UNDEFINED;
    /**
     * Hardware is able to detect and set code rate automatically.
     */
    public static final int CODERATE_AUTO = Constants.FrontendIsdbs3Coderate.AUTO;
    /**
     * 1_3 code rate.
     */
    public static final int CODERATE_1_3 = Constants.FrontendIsdbs3Coderate.CODERATE_1_3;
    /**
     * 2_5 code rate.
     */
    public static final int CODERATE_2_5 = Constants.FrontendIsdbs3Coderate.CODERATE_2_5;
    /**
     * 1_2 code rate.
     */
    public static final int CODERATE_1_2 = Constants.FrontendIsdbs3Coderate.CODERATE_1_2;
    /**
     * 3_5 code rate.
     */
    public static final int CODERATE_3_5 = Constants.FrontendIsdbs3Coderate.CODERATE_3_5;
    /**
     * 2_3 code rate.
     */
    public static final int CODERATE_2_3 = Constants.FrontendIsdbs3Coderate.CODERATE_2_3;
    /**
     * 3_4 code rate.
     */
    public static final int CODERATE_3_4 = Constants.FrontendIsdbs3Coderate.CODERATE_3_4;
    /**
     * 7_9 code rate.
     */
    public static final int CODERATE_7_9 = Constants.FrontendIsdbs3Coderate.CODERATE_7_9;
    /**
     * 4_5 code rate.
     */
    public static final int CODERATE_4_5 = Constants.FrontendIsdbs3Coderate.CODERATE_4_5;
    /**
     * 5_6 code rate.
     */
    public static final int CODERATE_5_6 = Constants.FrontendIsdbs3Coderate.CODERATE_5_6;
    /**
     * 7_8 code rate.
     */
    public static final int CODERATE_7_8 = Constants.FrontendIsdbs3Coderate.CODERATE_7_8;
    /**
     * 9_10 code rate.
     */
    public static final int CODERATE_9_10 = Constants.FrontendIsdbs3Coderate.CODERATE_9_10;

    /** @hide */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef(prefix = "ROLLOFF_",
            value = {ROLLOFF_UNDEFINED, ROLLOFF_0_03})
    public @interface Rolloff {}

    /**
     * Roll off type undefined.
     */
    public static final int ROLLOFF_UNDEFINED = Constants.FrontendIsdbs3Rolloff.UNDEFINED;
    /**
     * 0.03 roll off type.
     */
    public static final int ROLLOFF_0_03 = Constants.FrontendIsdbs3Rolloff.ROLLOFF_0_03;


    private final int mStreamId;
    private final int mStreamIdType;
    private final int mModulation;
    private final int mCoderate;
    private final int mSymbolRate;
    private final int mRolloff;

    private Isdbs3FrontendSettings(int frequency, int streamId, int streamIdType, int modulation,
            int coderate, int symbolRate, int rolloff) {
        super(frequency);
        mStreamId = streamId;
        mStreamIdType = streamIdType;
        mModulation = modulation;
        mCoderate = coderate;
        mSymbolRate = symbolRate;
        mRolloff = rolloff;
    }

    /**
     * Gets Stream ID.
     */
    public int getStreamId() {
        return mStreamId;
    }
    /**
     * Gets Stream ID Type.
     */
    @IsdbsFrontendSettings.StreamIdType
    public int getStreamIdType() {
        return mStreamIdType;
    }
    /**
     * Gets Modulation.
     */
    @Modulation
    public int getModulation() {
        return mModulation;
    }
    /**
     * Gets Code rate.
     */
    @Coderate
    public int getCoderate() {
        return mCoderate;
    }
    /**
     * Gets Symbol Rate in symbols per second.
     */
    public int getSymbolRate() {
        return mSymbolRate;
    }
    /**
     * Gets Roll off type.
     */
    @Rolloff
    public int getRolloff() {
        return mRolloff;
    }

    /**
     * Creates a builder for {@link Isdbs3FrontendSettings}.
     *
     * @param context the context of the caller.
     */
    @RequiresPermission(android.Manifest.permission.ACCESS_TV_TUNER)
    @NonNull
    public static Builder builder(@NonNull Context context) {
        TunerUtils.checkTunerPermission(context);
        return new Builder();
    }

    /**
     * Builder for {@link Isdbs3FrontendSettings}.
     */
    public static class Builder extends FrontendSettings.Builder<Builder> {
        private int mStreamId;
        private int mStreamIdType;
        private int mModulation;
        private int mCoderate;
        private int mSymbolRate;
        private int mRolloff;

        private Builder() {
        }

        /**
         * Sets Stream ID.
         */
        @NonNull
        public Builder setStreamId(int streamId) {
            mStreamId = streamId;
            return this;
        }
        /**
         * Sets StreamIdType.
         */
        @NonNull
        public Builder setStreamIdType(@IsdbsFrontendSettings.StreamIdType int streamIdType) {
            mStreamIdType = streamIdType;
            return this;
        }
        /**
         * Sets Modulation.
         */
        @NonNull
        public Builder setModulation(@Modulation int modulation) {
            mModulation = modulation;
            return this;
        }
        /**
         * Sets Code rate.
         */
        @NonNull
        public Builder setCoderate(@Coderate int coderate) {
            mCoderate = coderate;
            return this;
        }
        /**
         * Sets Symbol Rate in symbols per second.
         */
        @NonNull
        public Builder setSymbolRate(int symbolRate) {
            mSymbolRate = symbolRate;
            return this;
        }
        /**
         * Sets Roll off type.
         */
        @NonNull
        public Builder setRolloff(@Rolloff int rolloff) {
            mRolloff = rolloff;
            return this;
        }

        /**
         * Builds a {@link Isdbs3FrontendSettings} object.
         */
        @NonNull
        public Isdbs3FrontendSettings build() {
            return new Isdbs3FrontendSettings(mFrequency, mStreamId, mStreamIdType, mModulation,
                    mCoderate, mSymbolRate, mRolloff);
        }

        @Override
        Builder self() {
            return this;
        }
    }

    @Override
    public int getType() {
        return FrontendSettings.TYPE_ISDBS3;
    }
}
