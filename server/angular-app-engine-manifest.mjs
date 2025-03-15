
export default {
  basePath: 'https://github.com/yasserjer/gestion-projet',
  supportedLocales: {
  "en-US": ""
},
  entryPoints: {
    '': () => import('./main.server.mjs')
  },
};
