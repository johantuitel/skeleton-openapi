import { ApplicationConfig, importProvidersFrom } from '@angular/core';
import { provideRouter } from '@angular/router';

import { provideClientHydration } from '@angular/platform-browser';
import { ApiModule, Configuration, ConfigurationParameters } from './api/v1';
import { routes } from './app.routes';
import { environment } from './environments/environment';

export function apiConfigFactory(): Configuration {
  const params: ConfigurationParameters = {
    basePath: environment.basePath,
  };
  return new Configuration(params);
}

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes), provideClientHydration(), importProvidersFrom(ApiModule.forRoot(apiConfigFactory))]
};
