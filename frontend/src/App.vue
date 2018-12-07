<template>
    <div id="app">
        <b-container>
            <router-view></router-view>
        </b-container>
    </div>
</template>

<script>
    export default {
        name: 'app',
        data() {
            return {}
        }
    }
</script>
<style>
    #app {
        margin-top: 10px;
    }
</style>