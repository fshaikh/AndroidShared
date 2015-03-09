package com.reversecurrent.sharedandroid;

import com.reversecurrent.shared.IAudioManager;
import com.reversecurrent.shared.RingerType;
import com.reversecurrent.shared.StreamType;
import android.content.Context;
import android.media.AudioManager;

/**
 * Created by fshaikh on 28/02/2015.
 */
public class AndroidAudioManager implements IAudioManager {
    private AudioManager _audioManager;


    public AndroidAudioManager(Context context){
        _audioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
    }

    public boolean SetMaxVolume(StreamType streamType){
        if(_audioManager != null){
            _audioManager.setStreamVolume(streamType.ordinal(),
                    _audioManager.getStreamMaxVolume(streamType.ordinal()),
                    AudioManager.FLAG_ALLOW_RINGER_MODES| AudioManager.FLAG_PLAY_SOUND);
            return true;
        }
        return false;
    }

    public boolean SetToRingerMode(RingerType ringerType){
        if(_audioManager != null){
            //_audioManager.setRingerMode(ringerType.ordinal());
            _audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            return true;
        }
        return false;
    }
}
