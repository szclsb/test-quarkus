import React from "react";
import {Outlet} from "react-router-dom";
import {Box} from "@mui/material";

import {Header} from "app/components/Header";

export default function HeaderLayout() {
    return (<>
        <Header info='Test Quarkus'/>
        <Box sx={{
            padding: 1
        }}>
            <Outlet/>
        </Box>
    </>);
}
