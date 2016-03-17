/**
 *  DSC Stay Panel
 *
 *  Author: Jordan <jordan@xeron.cc
 *  Original Code By: Rob Fisher <robfish@att.net>, Carlos Santiago <carloss66@gmail.com>, JTT <aesystems@gmail.com>
 *  Date: 2016-02-03
 */
 // for the UI

metadata {
    // Automatically generated. Make future change here.
    definition (name: "DSC Stay Panel", author: "Jordan <jordan@xeron.cc>", namespace: 'dsc') {
        capability "Switch"

        command "away"
        command "bypassoff"
        command "disarm"
        command "instant"
        command "night"
        command "partition"
        command "panic"
        command "panicfire"
        command "panicambulance"
        command "panicpolice"
        command "reset"
        command "stay"
        command "togglechime"
    }

    // simulator metadata
    simulator {
    }

    // UI tile definitions
    tiles(scale: 2) {
      standardTile ("status", "device.status", width: 4, height: 4, title: "Status") {
        state "alarm", label:'Alarm', action: 'disarm', icon:"st.security.alarm.alarm", backgroundColor:"#ff0000"
        state "away", label:'Armed Away', action: 'disarm', icon:"st.security.alarm.on", backgroundColor:"#800000"
        state "disarm", label:'Disarmed', icon:"st.security.alarm.off", backgroundColor:"#79b821"
        state "entrydelay", label:'Entry Delay', action: 'disarm', icon:"st.security.alarm.on", backgroundColor:"#ff9900"
        state "exitdelay", label:'Exit Delay', action: 'disarm', icon:"st.security.alarm.on", backgroundColor:"#ff9900"
        state "notready", label:'Not Ready', icon:"st.security.alarm.off", backgroundColor:"#ffcc00"
        state "ready", label:'Ready', action: 'stay', icon:"st.security.alarm.off", backgroundColor:"#79b821"
        state "forceready", label:'Ready - F', action: 'stay', icon:"st.security.alarm.off", backgroundColor:"#79b821"
        state "stay", label:'Armed Stay', action: 'disarm', icon:"st.security.alarm.on", backgroundColor:"#008CC1"
        state "instantaway", label:'Armed Instant Away', action: 'stay', icon:"st.security.alarm.on", backgroundColor:"#800000"
        state "instantstay", label:'Armed Instant Stay', action: 'disarm', icon:"st.security.alarm.on", backgroundColor:"#008CC1"
      }
      standardTile("trouble", "device.trouble", width: 2, height: 2, title: "Trouble") {
        state "detected", label: 'Trouble', icon: "st.security.alarm.alarm", backgroundColor: "#ffa81e"
        state "clear", label: 'No\u00A0Trouble', icon: "st.security.alarm.clear", backgroundColor: "#79b821"
      }
      standardTile("chime", "device.chime", width: 2, height: 2, title: "Chime"){
        state "togglechime", label: 'Toggling\u00A0Chime', action: "togglechime", icon: "st.alarm.beep.beep", backgroundColor: "#fbd48a"
        state "chime", label: 'Chime', action: "togglechime", icon: "st.alarm.beep.beep", backgroundColor: "#EE9D00"
        state "nochime", label: 'No\u00A0Chime', action: "togglechime", icon: "st.alarm.beep.beep", backgroundColor: "#796338"
      }
      standardTile("disarm", "capability.momentary", width: 2, height: 2, title: "Disarm"){
        state "disarm", label: 'Disarm', action: "disarm", icon: "st.presence.house.unlocked", backgroundColor: "#79b821"
      }
      standardTile("away", "capability.momentary", width: 2, height: 2, title: "Away"){
        state "away", label: 'Away', action: "away", icon: "st.presence.car.car", backgroundColor: "#800000"
      }
      standardTile("stay", "capability.momentary", width: 2, height: 2, title: "Stay"){
        state "stay", label: 'Stay', action: "stay", icon: "st.presence.house.secured", backgroundColor: "#008CC1"
      }
      standardTile("instant", "capability.momentary", width: 2, height: 2, title: "Instant"){
        state "instant", label: 'Instant', action: "instant", icon: "st.locks.lock.locked", backgroundColor: "#00FF00"
      }
      standardTile("night", "capability.momentary", width: 2, height: 2, title: "Night"){
        state "night", label: 'Night', action: "night", icon: "st.Bedroom.bedroom2", backgroundColor: "#AA00FF"
      }
      standardTile("reset", "capability.momentary", width: 2, height: 2, title: "Sensor Reset"){
        state "reset", label: 'Sensor\u00A0Reset', action: "reset", icon: "st.alarm.smoke.smoke", backgroundColor: "#FF3000"
      }
      standardTile("bypassoff", "capability.momentary", width: 2, height: 2, title: "Bypass Off"){
        state "bypassoff", label: 'Bypass\u00A0Off', action: "bypassoff", icon: "st.locks.lock.unlocked", backgroundColor: "#FFFF00"
      }
      valueTile("ledready", "device.ledready", width: 2, height: 1){
        state "ledready", label:'Ready: ${currentValue}'
      }
      valueTile("ledarmed", "device.ledarmed", width: 2, height: 1){
        state "ledarmed", label:'Armed: ${currentValue}'
      }
      valueTile("ledmemory", "device.ledmemory", width: 2, height: 1){
        state "ledmemory", label:'Memory: ${currentValue}'
      }
      valueTile("ledbypass", "device.ledbypass", width: 2, height: 1){
        state "ledbypass", label:'Bypass: ${currentValue}'
      }
      valueTile("ledtrouble", "device.ledtrouble", width: 2, height: 1){
        state "ledtrouble", label:'Trouble: ${currentValue}'
      }
      valueTile("ledprogram", "device.ledprogram", width: 2, height: 1){
        state "ledprogram", label:'Program: ${currentValue}'
      }
      valueTile("ledfire", "device.ledfire", width: 2, height: 1){
        state "ledfire", label:'Fire: ${currentValue}'
      }
      valueTile("ledbacklight", "device.ledbacklight", width: 2, height: 1){
        state "ledbacklight", label:'Backlight: ${currentValue}'
      }
      standardTile("panic", "device.panic", width: 2, height: 2, title: "Panic"){
        state "nopanic", label: 'Panic\u00A0Off', action: "panic", icon: "st.illuminance.illuminance.dark", backgroundColor: "#7B3516", defaultState: true
        state "panic", label: 'Panic\u00A0On', action: "panic", icon: "st.illuminance.illuminance.light", backgroundColor: "#FF6E2E"
      }
      standardTile("panicfire", "capability.momentary", width: 2, height: 2, title: "Panic Fire"){
        state "panicfire", label: 'Panic\u00A0Fire', action: "panicfire", icon: "st.Home.home29", backgroundColor: "#FF2400"
      }
      standardTile("panicambulance", "capability.momentary", width: 2, height: 2, title: "Panic Ambulance"){
        state "panicambulance", label: 'Panic\u00A0Ambulance', action: "panicambulance", icon: "st.Transportation.transportation7", backgroundColor: "#DD0000"
      }
      standardTile("panicpolice", "capability.momentary", width: 2, height: 2, title: "Panic Fire"){
        state "panicpolice", label: 'Panic\u00A0Police', action: "panicpolice", icon: "st.Transportation.transportation9", backgroundColor: "#000fd5"
      }

      main "status"
      details(["status", "trouble", "chime", "away", "stay", "disarm", "instant", "night", "reset", "bypassoff", "ledready", "ledarmed", "ledmemory", "ledbypass", "panic", "ledtrouble", "ledprogram", "ledfire", "ledbacklight", "panicfire", "panicambulance", "panicpolice"])
    }
}

def partition(String state, String partition, Map parameters) {
  // state will be a valid state for the panel (ready, notready, armed, etc)
  // partition will be a partition number, for most users this will always be 1

  log.debug "Partition: ${state} for partition: ${partition}"

  def onList = ['alarm','entrydelay','exitdelay','instantstay','stay']

  def chimeList = ['chime','nochime']

  def troubleMap = [
    'trouble':"detected",
    'restore':"clear",
  ]

  if (onList.contains(state)) {
    sendEvent (name: "switch", value: "on")
  } else if (!(chimeList.contains(state) || troubleMap[state] || state.startsWith('led'))) {
    sendEvent (name: "switch", value: "off")
  }

  if (troubleMap[state]) {
    def troubleState = troubleMap."${state}"
    // Send trouble event
    sendEvent (name: "trouble", value: "${troubleState}")
  } else if (chimeList.contains(state)) {
    // Send chime event
    sendEvent (name: "chime", value: "${state}")
  } else if (state.startsWith('led')) {
    def flash = (state.startsWith('ledflash')) ? 'flash ' : ''
    for (p in parameters) {
      sendEvent (name: "led${p.key}", value: "${flash}${p.value}")
    }
  } else {
    // Send final event
    sendEvent (name: "status", value: "${state}")
  }
}

def away() {
  parent.sendUrl('arm')
}

def bypassoff() {
  parent.sendUrl("bypass?zone=0")
}

def disarm() {
  parent.sendUrl('disarm')
}

def instant() {
  parent.sendUrl('toggleinstant')
}

def night() {
  parent.sendUrl('togglenight')
}

def on() {
  stay()
}

def off() {
  disarm()
}

def panic() {
  if ("${device.currentValue("panic")}" == 'panic') {
    sendEvent (name: "panic", value: "nopanic")
  } else {
    sendEvent (name: "panic", value: "panic")
  }
}

def panicfire() {
  if ("${device.currentValue("panic")}" == 'panic') {
    parent.sendUrl('panic?type=1')
  }
}

def panicambulance() {
  if ("${device.currentValue("panic")}" == 'panic') {
    parent.sendUrl('panic?type=2')
  }
}

def panicpolice() {
  if ("${device.currentValue("panic")}" == 'panic') {
    parent.sendUrl('panic?type=3')
  }
}

def reset() {
  parent.sendUrl('reset')
}

def stay() {
  parent.sendUrl('stayarm')
}

def togglechime() {
  parent.sendUrl('togglechime')
}
