package com.example.payo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.SmsMessage
import android.util.Log
import java.lang.Exception
import java.util.regex.Pattern

class SmsListener : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "android.provider.Telephony.SMS_RECEIVED") {
            val bundle = intent.extras
            try {
                Log.d("Bundle", bundle?.get("pdus").toString())
                if (bundle != null) {
                    val pdusObj =
                        bundle["pdus"] as Array<Object>?
                    pdusObj?.forEach {
                        val currentMessage: SmsMessage
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            val format = bundle.getString("format")
                            currentMessage = SmsMessage.createFromPdu(
                                it as ByteArray,
                                format
                            )
                            Log.e(
                                "Current Message",
                                format + " : " + currentMessage.displayOriginatingAddress
                            )
                        } else {

                            currentMessage = SmsMessage.createFromPdu(it as ByteArray)

                        }

                        val regEx =
                            Pattern.compile("[a-zA-Z0-9]{2}-[a-zA-Z0-9]{6}")
                        val m = regEx.matcher(currentMessage.displayOriginatingAddress)
                        if (m.find()) {
                            try {
                                val phoneNumber = m.group(0)
                                val date = currentMessage.timestampMillis
                                val message = currentMessage.displayMessageBody
                                Log.e(
                                    "SmsReceiver Mine",
                                    "senderNum: $phoneNumber; message: $message"
                                )

                                if (message.contains("debited", true)) {
                                    Log.d("DEBITED___YES", "YESSSSSSSSS")
                                } else if (message.contains("credited", true)) {
                                    Log.d("CREDITED___YES", "YESSSSSSSSS")

                                } else {
                                    Log.d("CREDITED___YES", "NOOOOOOO")

                                }
                            } catch (e: Exception) {
                                Log.e("Mismatch", "Mismatch value")
                                e.printStackTrace()
                            }
                        } else {
                            Log.e("Mismatch", "Mismatch value")
                        }
                    }


                }
            } catch (e: Exception) {
                Log.e("SmsReceiver", "Exception smsReceiver$e")
            }
        }


    }
}