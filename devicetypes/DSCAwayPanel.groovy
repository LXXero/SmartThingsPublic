/**
 *  DSC Away Panel
 *
 *  Author: Jordan <jordan@xeron.cc
 *  Original Code By: Rob Fisher <robfish@att.net>, Carlos Santiago <carloss66@gmail.com>, JTT <aesystems@gmail.com>
 *  Date: 2016-02-03
 */
 // for the UI

preferences {
    input("ip", "text", title: "IP", description: "The IP of your alarmserver")
    input("port", "text", title: "Port", description: "The port")
} 
 
metadata {
    // Automatically generated. Make future change here.
    definition (name: "DSC Away Panel", author: "Jordan <jordan@xeron.cc>") {
        capability "Switch"
        
        command "away"
        command "bypass"
        command "bypassLevel"
        command "disarm"
        command "instant"
        command "night"
        command "partition"
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
            state "ready", label:'Ready', action: 'away', icon:"st.security.alarm.off", backgroundColor:"#79b821"
            state "forceready", label:'Ready - F', action: 'away', icon:"st.security.alarm.off", backgroundColor:"#79b821"
            state "stay", label:'Armed Stay', action: 'disarm', icon:"st.security.alarm.on", backgroundColor:"#008CC1"
            state "instantaway", label:'Armed Instant Away', action: 'disarm', icon:"st.security.alarm.on", backgroundColor:"#800000"
            state "instantstay", label:'Armed Instant Stay', action: 'away', icon:"st.security.alarm.on", backgroundColor:"#008CC1"
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
        controlTile("bypassSlider", "device.bypass", "slider", height: 1, width: 6, inactiveLabel: false, range:"(0..64)"){
            state "bypass", action:"bypassLevel"
        }
        valueTile("bypassValue", "device.bypass", width: 2, height: 2){
            state "bypass", label:'${currentValue}'
        }
        standardTile("bypass", "capability.momentary", width: 2, height: 2, title: "Bypass"){
            state "bypass", label: 'Bypass', action: "bypass", icon: "st.locks.lock.unlocked", backgroundColor: "#FFFF00"
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

        main "status"
        details(["status", "trouble", "chime", "away", "stay", "disarm", "instant", "night", "reset","bypassSlider","bypassValue","bypass", "ledready", "ledarmed", "ledmemory", "ledbypass", "ledtrouble", "ledprogram", "ledfire", "ledbacklight"])
    }
}

def parse(String description) {
}

def partition(String state, String partition) {
    // state will be a valid state for the panel (ready, notready, armed, etc)
    // partition will be a partition number, for most users this will always be 1

    log.debug "Partition: ${state} for partition: ${partition}"

    def onList = ['alarm','away','entrydelay','exitdelay','instantaway']

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
        int num = (Integer.parseInt(state.replaceAll(/(^ledflash|^led)/, ''), 16));
        def binary = (Integer.toBinaryString(num));
        binary = String.format("%08d", binary.toInteger())
        def flash = (state.startsWith('ledflash')) ? 'flash ' : ''

        def ledMap = [
          '0':'backlight',
          '1':'fire',
          '2':'program',
          '3':'trouble',
          '4':'bypass',
          '5':'memory',
          '6':'armed',
          '7':'ready'
        ]

        for (def i = 0; i < 8; i++) {
            def name = ledMap."${i}"
            def status = (binary[i] == '1') ? 'on' : 'off'
            sendEvent (name: "led${name}", value: "${flash}${status}")
        }
    } else {
        // Send final event
        sendEvent (name: "status", value: "${state}")
    }
}


def away() {
    def result = new physicalgraph.device.HubAction(
        method: "GET",
        path: "/api/alarm/arm",
        headers: [
            HOST: "$ip:$port"
        ]
    )
    log.debug "response" : "Request to away arm received"
    return result
}

def bypassLevel(level) {
    def result = sendEvent (name: "bypass", value: "${level}")
    log.debug "response" : "Bypass level set to ${level}"
    return result
}

def bypass() {
    def result = new physicalgraph.device.HubAction(
        method: "GET",
        path: "/api/alarm/bypass?zone=${device.currentValue("bypass")}",
        headers: [
            HOST: "$ip:$port"
        ]
    )
    log.debug "response" : "Request to bypass zone ${device.currentValue("bypass")} received"
    return result
}

def disarm() {
    def result = new physicalgraph.device.HubAction(
        method: "GET",
        path: "/api/alarm/disarm",
        headers: [
            HOST: "$ip:$port"
        ]
    )
    log.debug "response" : "Request to disarm received"
    return result
}

def instant() {
    def result = new physicalgraph.device.HubAction(
        method: "GET",
        path: "/api/alarm/toggleinstant",
        headers: [
            HOST: "$ip:$port"
        ]
    )
    log.debug "response" : "Request to toggle instant mode received"
    return result
}

def night() {
    def result = new physicalgraph.device.HubAction(
        method: "GET",
        path: "/api/alarm/togglenight",
        headers: [
            HOST: "$ip:$port"
        ]
    )
    log.debug "response" : "Request to toggle night mode received"
    return result
}

def on() {
    away()
}

def off() {
    disarm()
}

def reset() {
    def result = new physicalgraph.device.HubAction(
        method: "GET",
        path: "/api/alarm/reset",
        headers: [
            HOST: "$ip:$port"
        ]
    )
    log.debug "response" : "Request to sensor reset received"
    return result
}

def stay() {
    def result = new physicalgraph.device.HubAction(
        method: "GET",
        path: "/api/alarm/stayarm",
        headers: [
            HOST: "$ip:$port"
        ]
    )
    log.debug "response" : "Request to stay arm received"
    return result
}

def togglechime() {
    def result = new physicalgraph.device.HubAction(
        method: "GET",
        path: "/api/alarm/togglechime",
        headers: [
            HOST: "$ip:$port"
        ]
    )
    log.debug "response" : "Request to toggle chime received"
    return result
}
