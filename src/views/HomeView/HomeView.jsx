import { useState } from "react";
import styles from "./HomeView.module.css"; 

export default function HomeView() {

return (

    <main className= {styles.main}>
        
        <div className= {styles.missionStatement}>
            <h2>Our Mission</h2>
            <p>At State of Support, we believe that no one facing domestic violence should ever feel alone or without options. Our mission is to connect survivors, advocates, and community members with life-saving resources by providing a comprehensive, easy-to-use platform that helps users locate nearby shelters, discover local charities accepting donations, and understand the specific laws protecting domestic violence survivors in their state. We are committed to breaking down barriers to information and empowering individuals to find the help they need—or give the help others desperately seek—because safety, support, and hope should always be within reach.</p>
        </div>
        
        
        
    </main>
); 

};